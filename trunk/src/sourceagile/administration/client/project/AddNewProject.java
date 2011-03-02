package sourceagile.administration.client.project;

import sourceagile.administration.client.Administration;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class AddNewProject {

	public AddNewProject(final Project project) {

		final ProjectAdministrationServerCallsAsync databaseServerCalls = GWT
				.create(ProjectAdministrationServerCalls.class);

		databaseServerCalls.saveProject(project, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(new Administration());
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}
		});
	}

}
