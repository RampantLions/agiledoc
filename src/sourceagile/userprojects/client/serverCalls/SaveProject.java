package sourceagile.userprojects.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveProject {

	public SaveProject(Project project) {

		final DatabaseAccessServerCallsAsync databaseServerCalls = GWT
				.create(DatabaseAccessServerCalls.class);

		databaseServerCalls.saveProject(project, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {

			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
