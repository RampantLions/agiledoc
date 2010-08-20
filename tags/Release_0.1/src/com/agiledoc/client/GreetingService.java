package com.agiledoc.client;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	Project listClasses(Project proj);

	void createClasse(Project proj, Classe classe) throws Exception;

	Classe getClasse(Project proj, String className);

	String getSourceCode(Project proj, Classe classe);

}
