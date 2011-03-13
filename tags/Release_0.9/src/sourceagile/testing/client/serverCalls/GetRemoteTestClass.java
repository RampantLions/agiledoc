package sourceagile.testing.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FileNameGenerator;
import sourceagile.shared.utilities.LoadingPanel;
import sourceagile.testing.client.UnitTestView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteTestClass {

	public GetRemoteTestClass(ClassFile entry) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel.add(new LoadingPanel());

		if (Project.REPOSITORY_TYPE_SUBVERSION
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

			getRemoteTestClassesFromSubversion(entry);

		} else if (Project.REPOSITORY_TYPE_GIT
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

		} else if (Project.REPOSITORY_TYPE_XML
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

			getRemoteTestClassesFromXML(entry);
		}
	}

	private void getRemoteTestClassesFromSubversion(final ClassFile entry) {

		LoadRemoteTestClassesAsync remoteFunctions = GWT
				.create(LoadRemoteTestClasses.class);

		remoteFunctions.getTestClass(ProjectInitialization.currentProject,
				GlobalVariables.currentUser, entry,
				new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile testEntry) {

						Development.featureVisualizationPanel.clear();
						Development.featureVisualizationPanel
								.add(new FeatureVizualizationPanel(entry));

						FeatureVizualizationPanel.featureContent
								.add(new UnitTestView(entry, testEntry));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}

	private void getRemoteTestClassesFromXML(final ClassFile classFile) {

		final String testClassName = classFile.getClassDoc().getClassName()
				+ "Test.java";

		RequestBuilder requestBuilder = new RequestBuilder(
				RequestBuilder.GET,
				"files/mockup/"
						+ FileNameGenerator
								.compactName(ProjectInitialization.currentProject
										.getName()) + "/tests/" + testClassName);

		try {
			requestBuilder.sendRequest(null, new RequestCallback() {

				public void onResponseReceived(Request request,
						Response response) {

					ClassFile classFileTest = null;

					if (!(response.getStatusCode() == 404)) {

						classFileTest = new ClassFile();

						classFileTest.setFileName(testClassName);

						classFileTest.setFilePath(classFile.getFilePath());

						classFileTest.setSourceCode(response.getText());
					}

					Development.featureVisualizationPanel.clear();
					Development.featureVisualizationPanel
							.add(new FeatureVizualizationPanel(classFile));

					FeatureVizualizationPanel.featureContent
							.add(new UnitTestView(classFile, classFileTest));
				}

				public void onError(Request request, Throwable exception) {

					Window.alert("Failed to send the message: "
							+ exception.getMessage());
				}
			});

		} catch (RequestException e) {

			e.printStackTrace();
		}
	}

}
