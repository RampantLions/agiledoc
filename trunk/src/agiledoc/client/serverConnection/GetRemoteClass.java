package agiledoc.client.serverConnection;

import agiledoc.client.SystemInitialization;
import agiledoc.client.features.FeaturesPage;
import agiledoc.client.features.featureOptions.FeatureContentPanel;
import agiledoc.client.features.featureOptions.FeatureDescription;
import agiledoc.client.features.featureOptions.OptionsIcons;
import agiledoc.client.navigation.LoadingPanel;
import agiledoc.shared.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteClass {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public GetRemoteClass(Entry entry, final int viewOption) {

		FeaturesPage.featureVisualizationPanel.clear();
		FeaturesPage.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getEntryFeature(SystemInitialization.currentProject,
				SystemInitialization.currentUser, entry,
				new AsyncCallback<Entry>() {

					public void onSuccess(Entry entry) {

						FeaturesPage.featureVisualizationPanel.clear();
						FeaturesPage.featureVisualizationPanel
								.add(new FeatureContentPanel(entry));

						if (viewOption == OptionsIcons.optionDescription) {

							FeatureContentPanel.featureContent
									.add(new FeatureDescription(entry));
						}
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
