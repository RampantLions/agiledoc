package agiledoc.client.serverConnection;

import agiledoc.client.features.FeatureVisualization;
import agiledoc.client.features.FeaturesPage;
import agiledoc.shared.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteClass {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public GetRemoteClass(Entry entry) {

		remoteFunctions.getEntryFeature(entry, new AsyncCallback<Entry>() {

			public void onSuccess(Entry entry) {

				FeaturesPage.featureVisualizationPanel.clear();
				FeaturesPage.featureVisualizationPanel
						.add(new FeatureVisualization());

				String sourceCode = entry.getTextContent();

				sourceCode = sourceCode.replaceAll("\n", "<br>");
				sourceCode = sourceCode.replaceAll("\t",
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

				FeatureVisualization.featureContent.setHTML(sourceCode);
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
