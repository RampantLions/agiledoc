package sourceagile.testing.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.documentation.client.classViewOptions.ClassVizualizationPanel;
import sourceagile.documentation.client.specification.Specification;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.testing.client.TestClassDescription;
import sourceagile.userprojects.client.ProjectInitialization;

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
