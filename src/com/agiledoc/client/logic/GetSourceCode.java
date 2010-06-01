package com.agiledoc.client.logic;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.sourceCode.SourceCodePage;
import com.agiledoc.client.view.util.LoadingPanel;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GetSourceCode {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public GetSourceCode(final Classe classe, final VerticalPanel vpanel) {

		vpanel.clear();
	//	vpanel.add(new LoadingPanel());

		greetingService.getSourceCode(GlobalVariables.getProject(), classe,
				new AsyncCallback<String>() {

					public void onSuccess(String result) {

						vpanel.clear();
						vpanel.add(new SourceCodePage(classe, result));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
