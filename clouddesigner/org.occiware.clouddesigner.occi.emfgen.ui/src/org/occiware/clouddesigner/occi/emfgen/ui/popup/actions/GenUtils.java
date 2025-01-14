package org.occiware.clouddesigner.occi.emfgen.ui.popup.actions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.ui.tools.api.project.ViewpointSpecificationProject;
import org.eclipse.ui.PlatformUI;
import org.occiware.clouddesigner.occi.emfgen.ConverterUtils;

public class GenUtils {

	public static IProject genDesignProject(String projectName, String modelName, ProgressMonitorDialog dialog)
			throws CoreException, IOException {
		final IPath projectLocationPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		IProject project = ViewpointSpecificationProject.createNewViewpointSpecificationProject(
				PlatformUI.getWorkbench(), projectName, projectLocationPath, modelName,
				ViewpointSpecificationProject.INITIAL_OBJECT_NAME, ViewpointSpecificationProject.ENCODING_DEFAULT,
				dialog);

		// add dependency to the metamodel
		IFile file = PDEProject.getManifest(project);
		StringBuffer buffer = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(file.getContents()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			buffer.append(inputLine + "\n");
			if (inputLine.startsWith("Require-Bundle:")) {
				buffer.append(" org.occiware.clouddesigner.occi,\n");
				buffer.append(" org.occiware.clouddesigner.occi.design,\n");
			}
		}
		in.close();
		file.setContents(new ByteArrayInputStream(buffer.toString().getBytes()), 0, null);
		return project;
	}

	public static IProject genDesignTestProject(IProject designProject, IProgressMonitor monitor) throws CoreException {
		final IPath projectLocationPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		return ModelingProjectManager.INSTANCE.createNewModelingProject(designProject.getName() + ".tests",
				projectLocationPath, true, monitor);
	}

	public static GenPackage createGenModel(final EPackage rootPackage, final String ecoreLocation, String basePackage,
			Collection<GenPackage> usedGenPackages) throws IOException {
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setComplianceLevel(GenJDKLevel.JDK70_LITERAL);
		String modelPluginId = new Path(ecoreLocation).removeLastSegments(2).lastSegment().toString();
		String editPluginId = modelPluginId + ".edit";
		genModel.setModelDirectory('/' + modelPluginId + "/src-gen");
		genModel.setEditDirectory('/' + editPluginId + "/src-gen");
		genModel.getForeignModel().add(new Path(ecoreLocation).lastSegment());
		genModel.setModelName(ConverterUtils.toU1Case(rootPackage.getName()));
		genModel.setModelPluginID(modelPluginId);
		genModel.setEditorPluginID(editPluginId);
		genModel.setRootExtendsInterface("org.eclipse.emf.ecore.EObject");
		genModel.getUsedGenPackages().addAll(usedGenPackages);
		genModel.initialize(Collections.singleton(rootPackage));
		GenPackage genPackage = genModel.getGenPackages().get(0);
		genPackage.setPrefix(rootPackage.getNsPrefix());
		genPackage.setBasePackage(basePackage);

		URI genModelURI = URI
				.createFileURI(new Path(ecoreLocation).removeFileExtension().addFileExtension("genmodel").toString());
		final XMIResourceImpl genModelResource = new XMIResourceImpl(genModelURI);
		genModelResource.getContents().add(genModel);
		genModelResource.save(Collections.EMPTY_MAP);
		return genPackage;
	}
}
