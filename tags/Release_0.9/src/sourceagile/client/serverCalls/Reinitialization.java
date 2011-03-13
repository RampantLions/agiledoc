package sourceagile.client.serverCalls;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Reinitialization {

	public Reinitialization(Long projectID) {

		final ProjectDatabaseServerCallsAsync databaseServerCalls = GWT
				.create(ProjectDatabaseServerCalls.class);

		databaseServerCalls.getProject(projectID, new AsyncCallback<Project>() {

			public void onSuccess(Project project) {

				new ProjectInitialization(project);
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
