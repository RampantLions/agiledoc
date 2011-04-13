package sourceagile.authentication.client.serverCalls;

import sourceagile.administration.client.project.ProjectAdministrationServerCalls;
import sourceagile.administration.client.project.ProjectAdministrationServerCallsAsync;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddNewProject {

	public AddNewProject(final Project project) {

		final ProjectAdministrationServerCallsAsync databaseServerCalls = GWT
				.create(ProjectAdministrationServerCalls.class);

		databaseServerCalls.saveProject(project, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {

				new ListProjects();
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}
		});
	}

}
