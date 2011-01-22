package sourceagile.authentication.client.serverCalls;

import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectInitialization;
import sourceagile.userprojects.client.serverCalls.ProjectDatabaseServerCalls;
import sourceagile.userprojects.client.serverCalls.ProjectDatabaseServerCallsAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetLoginProject {

	public GetLoginProject(Long projectID) {

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
