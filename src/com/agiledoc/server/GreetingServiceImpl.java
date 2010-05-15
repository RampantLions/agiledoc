package com.agiledoc.server;

import com.agiledoc.client.GreetingService;
import com.agiledoc.server.sourceClasses.CreateClasse;
import com.agiledoc.server.sourceClasses.GetClasse;
import com.agiledoc.server.sourceClasses.ListSourceClasses;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public Project listClasses(Project proj) {

		return ListSourceClasses.ListClasses(proj);
	}

	@Override
	public Classe getClasse(Project proj, String className) {

		return GetClasse.returnClasse(proj, className);
	}

	@Override
	public void createClasse(Project proj, Classe classe) throws Exception {

		new CreateClasse(proj, classe);
	}

}
