package com.agiledoc.client.view.javadoc;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/08/2010
 */
public class ClassPage {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public ClassPage(Classe classe) {

		JavadocView.vpBodyJavadoc.clear();

		getJavadocClassPage(classe);
	}

	public void getJavadocClassPage(final Classe classe) {

		greetingService.showClass(GlobalVariables.getROOT(), GlobalVariables
				.getPACK(), classe, new AsyncCallback<String>() {

			public void onSuccess(String result) {

				JavadocView.vpBodyJavadoc.add(new HTML(result));
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
