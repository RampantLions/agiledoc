package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.features.SourceCodePage;
import com.agiledoc.client.view.help.HelpView;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetSourceCode {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public GetSourceCode(final Classe classe) {

		greetingService.getSourceCode(GlobalVariables.getProject(), classe,
				new AsyncCallback<String>() {

					public void onSuccess(String result) {

						HelpView.showFeature(
								new SourceCodePage(classe, result), classe);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
