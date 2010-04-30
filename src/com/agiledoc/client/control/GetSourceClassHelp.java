package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.help.HelpView;
import com.agiledoc.client.view.help.TopicPage;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetSourceClassHelp {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public GetSourceClassHelp(String className) {

		HelpView.vpBodyHelp.clear();

		greetingService.getClasse(GlobalVariables.getProject(), className,
				new AsyncCallback<Classe>() {

					public void onSuccess(Classe result) {

						if (result != null) {
							TopicPage.showHelpTopic(result);
						}
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
