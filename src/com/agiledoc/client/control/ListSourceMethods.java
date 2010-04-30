package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.features.FeaturesView;
import com.agiledoc.client.view.features.ShowSteps;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListSourceMethods {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * List from the source code all the methods contented in that class.
	 */
	public ListSourceMethods(final Classe classe) {

		greetingService.listMethods(GlobalVariables.getProject(), classe,
				new AsyncCallback<Method[]>() {

					public void onSuccess(Method[] result) {

						FeaturesView.vpBodyScope
								.add(ShowSteps.showMethods(result));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
