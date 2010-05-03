package com.agiledoc.client;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void listClasses(Project proj, AsyncCallback<Classe[]> callback);

	void showClass(Project proj, Classe classe, AsyncCallback<String> callback);

	void getClasse(Project proj, String className,
			AsyncCallback<Classe> callback);

}
