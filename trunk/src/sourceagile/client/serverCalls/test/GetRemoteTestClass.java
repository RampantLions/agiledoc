package sourceagile.client.serverCalls.test;

import sourceagile.client.SystemStart;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.userFeatures.documentation.classViewOptions.ClassVizualizationPanel;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.client.userFeatures.testing.TestClassDescription;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteTestClass {

	private final LoadRemoteTestClassesAsync remoteFunctions = GWT
			.create(LoadRemoteTestClasses.class);

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
								.add(new TestClassDescription(entry, testEntry));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
