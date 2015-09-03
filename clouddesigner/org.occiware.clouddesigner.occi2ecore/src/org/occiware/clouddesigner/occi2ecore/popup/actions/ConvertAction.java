package org.occiware.clouddesigner.occi2ecore.popup.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.occiware.clouddesigner.occi.Extension;
import org.occiware.clouddesigner.occi2ecore.ConverterUtils;
import org.occiware.clouddesigner.occi2ecore.OCCIExtension2Ecore;

public class ConvertAction implements IObjectActionDelegate {

	private static final String ECORE_PLATFORM_URI = "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore";

	private static final String CORE_GEN_PACKAGE_URI = "platform:/plugin/org.occiware.clouddesigner.occi/model/OCCI.genmodel";

	private ISelection selection;

	private Collection<GenPackage> usedPackages = new ArrayList<GenPackage>();

	/**
	 * Constructor for Action1.
	 */
	public ConvertAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	@Override
	public void run(IAction action) {
		IFile occieFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
		try {
			generateExtension(occieFile.getFullPath().removeFileExtension().lastSegment().toLowerCase(),
					occieFile.getParent().getLocation().toString());
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void generateExtension(String extensionName, String modelPath)
			throws IOException, InvocationTargetException, InterruptedException, CoreException {

		/*
		 * OCCIE => Ecore conversion
		 */

		ResourceSet resourceSet = new ResourceSetImpl();
		EPackage.Registry.INSTANCE.put(ECORE_PLATFORM_URI, EcorePackage.eINSTANCE);

		String ecoreLocation = modelPath + "/" + ConverterUtils.toU1Case(extensionName) + ".ecore";

		Extension ext = (Extension) ConverterUtils.getRootElement(resourceSet,
				"file:/" + modelPath + "/" + extensionName + ".occie");

		EPackage ePackage = new OCCIExtension2Ecore().convertExtension(ext);
		resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		ConverterUtils.persistMetamodel(resourceSet, ePackage, ecoreLocation);

		/*
		 * Fetching ext genmodels
		 */

		for (Extension extension : ext.getImport()) {
			if (!extension.getName().equals("core")) {
				GenModel genModel = (GenModel) resourceSet
						.getResource(
								URI.createURI(
										extension.eResource().getURI().toString().replaceAll(".occie", ".genmodel")),
								true)
						.getContents().get(0);
				usedPackages.add(genModel.getGenPackages().get(0));
			}
		}

		/*
		 * Create genmodel
		 */

		String modelPluginId = new Path(ecoreLocation).removeLastSegments(2).lastSegment().toString();
		String basePackage = modelPluginId.substring(0, modelPluginId.length() - (extensionName.length() + 1));

		GenPackage coreGenPackage = (GenPackage) ConverterUtils.getRootElement(resourceSet, CORE_GEN_PACKAGE_URI)
				.eContents().get(1);
		usedPackages.add(coreGenPackage);
		EMFGenUtils.createGenModel(ePackage, ecoreLocation, basePackage, usedPackages);

		/*
		 * Generate model & edit
		 */

		String genModelPath = modelPath + "/" + ConverterUtils.toU1Case(extensionName) + ".genmodel";
		EMFGenUtils.regenEMF(resourceSet, genModelPath);

		/*
		 * Create design project
		 */
		IProject project = DesignGenUtils.genDesignProject(modelPluginId + ".design", ePackage.getName() + ".odesign");

		/*
		 * Create design model
		 */
		IContainer target = project.getFolder("description");
		DesignGenUtils.genDesignModel(project.getWorkspace().getRoot().getFile(new Path(ecoreLocation)), target);

		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		project.getWorkspace().getRoot().getFile(new Path(ecoreLocation)).getProject()
				.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

}
