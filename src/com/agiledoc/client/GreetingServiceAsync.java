package com.agiledoc.client;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void listClasses(Project proj, AsyncCallback<Project> callback);

	void createClasse(Project proj, Classe classe, AsyncCallback<Void> callback);

	void getClasse(Project proj, String className,
			AsyncCallback<Classe> callback);

}
