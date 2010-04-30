package com.agiledoc.server;

import com.agiledoc.client.GreetingService;
import com.agiledoc.server.sourceClasses.GetClasse;
import com.agiledoc.server.sourceClasses.GetJavadocClass;
import com.agiledoc.server.sourceClasses.ListSourceClasses;
import com.agiledoc.server.sourceMethods.ListSourceMethods;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.agiledoc.shared.model.Project;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public Classe[] listClasses(Project proj) {

		return ListSourceClasses.ListClasses(proj);
	}

	@Override
	public Method[] listMethods(Project proj, Classe classe) {

		return ListSourceMethods.listMethods(proj, classe);
	}

	@Override
	public String showClass(Project proj, Classe classe) {

		return GetJavadocClass.showClass(proj, classe);
	}

	@Override
	public Classe getClasse(Project proj, String className) {

		return GetClasse.returnClasse(proj, className);
	}

}
