package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.client.features.FeaturesPage;
import agiledoc.shared.Feature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListRemoteClasses {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public ListRemoteClasses() {

		remoteFunctions.ListFeatures(new AsyncCallback<List<Feature>>() {

			public void onSuccess(List<Feature> features) {

				FeaturesPage.ShowFeatureTree(features);
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
