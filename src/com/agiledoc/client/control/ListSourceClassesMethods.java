package com.agiledoc.client.control;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.GreetingService;
import com.agiledoc.client.GreetingServiceAsync;
import com.agiledoc.client.view.measurements.MeasurementsView;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListSourceClassesMethods {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public ListSourceClassesMethods(String pack) {

		readSourceClasses(pack);
	}

	/**
	 * Read the classes from the source code of the system root, and storage in
	 * a global variable.
	 * 
	 * @author allineo
	 * @modified
	 * 
	 */
	public void readSourceClasses(String pack) {

		greetingService.listClasses(GlobalVariables.getROOT(), pack,
				new AsyncCallback<Classe[]>() {

					public void onSuccess(Classe[] result) {

						GlobalVariables.setCLASSES_LIST(result);

						MeasurementsView.init();
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
