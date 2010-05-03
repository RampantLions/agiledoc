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

	Classe[] listClasses(Project proj);

	String showClass(Project proj, Classe classe);

	Classe getClasse(Project proj, String className);

}
