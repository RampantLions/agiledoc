package sourceagile.client.serverCalls.test;

import sourceagile.client.SystemStart;
import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.client.serverCalls.LoadRemoteClassesAsync;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.client.userFeatures.specification.Specification;
import sourceagile.client.userFeatures.specification.classViewOptions.ClassVizualizationPanel;
import sourceagile.client.userFeatures.systemNavigation.LoadingPanel;
import sourceagile.client.userFeatures.testing.TestClassDescription;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteTestClass {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public GetRemoteTestClass(final ClassFile entry, final int viewOption) {

		Specification.featureVisualizationPanel.clear();
		Specification.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getTestClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, entry, new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile testEntry) {

						Specification.featureVisualizationPanel.clear();
						Specification.featureVisualizationPanel
								.add(new ClassVizualizationPanel(entry));

						ClassVizualizationPanel.featureContent
								.add(new TestClassDescription(testEntry));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
