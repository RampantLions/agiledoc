package sourceagile.client.serverConnection;

import sourceagile.client.SystemInitialization;
import sourceagile.client.features.FeaturesPage;
import sourceagile.shared.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListRemoteClasses {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public ListRemoteClasses() {

		remoteFunctions.ListFeatures(SystemInitialization.currentProject,
				SystemInitialization.currentUser, new AsyncCallback<Entry[]>() {

					public void onSuccess(Entry[] entries) {

						FeaturesPage.ShowFeatureTree(entries);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
