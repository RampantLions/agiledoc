package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.client.SystemInitialization;
import agiledoc.client.features.FeaturesPage;
import agiledoc.shared.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListRemoteClasses {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public ListRemoteClasses() {

		remoteFunctions.ListFeatures(SystemInitialization.currentProject,
				SystemInitialization.currentUser,
				new AsyncCallback<List<Entry>>() {

					public void onSuccess(List<Entry> entries) {

						FeaturesPage.ShowFeatureTree(entries);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
