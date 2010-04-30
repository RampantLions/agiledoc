package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.features.FeaturesView;
import com.agiledoc.client.view.util.LoadingPanel;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListSourceClasses {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public ListSourceClasses() {

		GlobalVariables.setVP_BODY(LoadingPanel.show());

		greetingService.listClasses(GlobalVariables.getProject(),
				new AsyncCallback<Classe[]>() {

					public void onSuccess(Classe[] result) {

						GlobalVariables.getProject().setClasses(result);

						FeaturesView.init();
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
