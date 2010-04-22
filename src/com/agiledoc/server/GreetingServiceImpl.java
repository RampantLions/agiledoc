package com.agiledoc.server;

import com.agiledoc.client.GreetingService;
import com.agiledoc.server.sourceClasses.GetClasse;
import com.agiledoc.server.sourceClasses.GetJavadocClass;
import com.agiledoc.server.sourceClasses.ListSourceClasses;
import com.agiledoc.server.sourceClasses.ListSourceClassesAndMethods;
import com.agiledoc.server.sourceMethods.ListSourceMethods;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public Classe[] listClasses(String root, String pack) {

		return ListSourceClasses.ListClasses(root, pack);
	}

	@Override
	public Method[] listMethods(String root, String pack, Classe classe) {

		return ListSourceMethods.listMethods(root, pack, classe);
	}

	@Override
	public String showClass(String root, String pack, Classe classe) {

		return GetJavadocClass.showClass(root, pack, classe);
	}

	@Override
	public Classe getClasse(String root, String pack, String className) {

		return GetClasse.returnClasse(root, pack, className);
	}

	@Override
	public Classe[] listClassesAndMethods(String root, String pack) {

		return ListSourceClassesAndMethods.ListClasses(root, pack);
	}

}
