package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.javadoc.JavadocView;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

public class GetJavadocClass {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public GetJavadocClass(Classe classe) {

		JavadocView.vpBodyJavadoc.clear();

		getJavadocClassPage(classe);
	}

	public void getJavadocClassPage(final Classe classe) {

		greetingService.showClass(GlobalVariables.getProject(), classe,
				new AsyncCallback<String>() {

					public void onSuccess(String result) {

						JavadocView.vpBodyJavadoc.add(new HTML(result));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
