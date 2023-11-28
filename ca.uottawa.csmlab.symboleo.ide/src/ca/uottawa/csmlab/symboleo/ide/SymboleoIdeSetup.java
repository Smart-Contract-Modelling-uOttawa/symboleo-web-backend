/*
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.ide;

import ca.uottawa.csmlab.symboleo.SymboleoRuntimeModule;
import ca.uottawa.csmlab.symboleo.SymboleoStandaloneSetup;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class SymboleoIdeSetup extends SymboleoStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new SymboleoRuntimeModule(), new SymboleoIdeModule()));
	}
	
}
