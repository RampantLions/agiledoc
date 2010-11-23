package sourceagile.userprojects.client.serverCalls;

import java.util.List;

import sourceagile.client.SystemStart;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectSelection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListProjects {

	public ListProjects() {

		final DatabaseAccessServerCallsAsync databaseServerCalls = GWT
				.create(DatabaseAccessServerCalls.class);

		databaseServerCalls.listProjects(new AsyncCallback<List<Project>>() {

			public void onSuccess(List<Project> projects) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent.add(new ProjectSelection(
						projects));
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
