/*
 * generated by Xtext
 */
package org.occiware.clouddesigner.occi.xtext;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class OCCIUiInjectorProvider implements IInjectorProvider {
	
	@Override
	public Injector getInjector() {
		return org.occiware.clouddesigner.occi.xtext.ui.internal.OCCIActivator.getInstance().getInjector("org.occiware.clouddesigner.occi.xtext.OCCI");
	}
	
}