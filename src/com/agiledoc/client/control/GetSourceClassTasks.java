package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.tasks.TaskPage;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetSourceClassTasks {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public GetSourceClassTasks(String className) {

		greetingService.getClasse(GlobalVariables.getROOT(), GlobalVariables
				.getPACK(), className, new AsyncCallback<Classe>() {

			public void onSuccess(Classe result) {

				TaskPage.show(result);
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
