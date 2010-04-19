package com.agiledoc.client;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	String showClass(String root, String pack, Classe classe);

	Classe[] listClasses(String root, String pack);

	Method[] listMethods(String root, String pack, Classe classe);

	Classe getClasse(String root, String pack, String className);

}
