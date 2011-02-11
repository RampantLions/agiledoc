package sourceagile.client.serverCalls;

import java.util.HashMap;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.LoadingPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListRemoteClasses {

	public ListRemoteClasses() {

		RootPanel.get("htmlID").clear();
		RootPanel.get("htmlID").add(new LoadingPanel());

		if (Project.REPOSITORY_TYPE_SUBVERSION
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

			// listRemoteClassesFromSubversion();
			listRemoteClassesFromXML();

		} else if (Project.REPOSITORY_TYPE_GIT
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

			listRemoteClassesFromGit();

		} else if (Project.REPOSITORY_TYPE_XML
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

			listRemoteClassesFromXML();
		}
	}

	private void listRemoteClassesFromXML() {

		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET,
				"files/TicTacToe_Specification.xml");

		try {
			requestBuilder.sendRequest(null, new RequestCallback() {

				public void onResponseReceived(Request request,
						Response response) {

					HashMap<String, ClassFile> classFiles = ConvertRemoteClassesXML
							.getClasses(response.getText());

					ProjectInitialization.projectEntries = classFiles;

					GlobalVariables.mainPage = new MainPage();

					RootPanel.get("htmlID").clear();
					RootPanel.get("htmlID").add(GlobalVariables.mainPage);

					new LoadMockupClasses(classFiles);
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

	private void listRemoteClassesFromSubversion() {

		final LoadRemoteClassesAsync subversionRemoteFunctions = GWT
				.create(LoadRemoteClasses.class);

		subversionRemoteFunctions.listClasses(
				ProjectInitialization.currentProject,
				GlobalVariables.currentUser,
				new AsyncCallback<HashMap<String, ClassFile>>() {

					public void onSuccess(HashMap<String, ClassFile> entries) {

						ProjectInitialization.projectEntries = entries;

						GlobalVariables.mainPage = new MainPage();

						RootPanel.get("htmlID").clear();
						RootPanel.get("htmlID").add(GlobalVariables.mainPage);

						new ListComponentClasses();
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}
				});
	}

	private void listRemoteClassesFromGit() {

	}
}
