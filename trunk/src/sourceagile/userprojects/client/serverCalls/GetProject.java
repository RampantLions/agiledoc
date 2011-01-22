package sourceagile.userprojects.client.serverCalls;

import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetProject {

	public GetProject(Long projectID) {

		final ProjectDatabaseServerCallsAsync databaseServerCalls = GWT
				.create(ProjectDatabaseServerCalls.class);

		databaseServerCalls.getProject(projectID, new AsyncCallback<Project>() {

			public void onSuccess(Project project) {

				ProjectForm.setProjectForm(project);
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
