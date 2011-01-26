package sourceagile.testing.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.testing.client.TestClassDescription;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteTestClass {

	private final LoadRemoteTestClassesAsync remoteFunctions = GWT
			.create(LoadRemoteTestClasses.class);

	public GetRemoteTestClass(final ClassFile entry, final int viewOption) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getTestClass(ProjectInitialization.currentProject,
				GlobalVariables.currentUser, entry,
				new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile testEntry) {

						Development.featureVisualizationPanel.clear();
						Development.featureVisualizationPanel
								.add(new FeatureVizualizationPanel(entry));

						FeatureVizualizationPanel.featureContent
								.add(new TestClassDescription(entry, testEntry));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
