package com.agiledoc.client;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void showClass(String root, String pack, Classe classe,
			AsyncCallback<String> callback);

	void listClasses(String root, String pack, AsyncCallback<Classe[]> callback);

	void listMethods(String root, String pack, Classe classe,
			AsyncCallback<Method[]> callback);

	void getClasse(String root, String pack, String className,
			AsyncCallback<Classe> callback);

	void listClassesAndMethods(String root, String pack,
			AsyncCallback<Classe[]> callback);

}
