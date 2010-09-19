package sourceagile.client.serverConnection;

import sourceagile.client.SystemInitialization;
import sourceagile.client.features.FeaturesPage;
import sourceagile.client.features.featureOptions.FeatureContentPanel;
import sourceagile.client.features.featureOptions.FeatureDescription;
import sourceagile.client.features.featureOptions.OptionsIcons;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteClass {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public GetRemoteClass(ClassFile entry, final int viewOption) {

		FeaturesPage.featureVisualizationPanel.clear();
		FeaturesPage.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getEntryFeature(ProjectInitialization.currentProject,
				SystemInitialization.currentUser, entry,
				new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile entry) {

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
