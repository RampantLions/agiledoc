package sourceagile.authentication.client.serverCalls;

import java.util.List;

import sourceagile.authentication.client.Login;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.serverCalls.ProjectDatabaseServerCalls;
import sourceagile.userprojects.client.serverCalls.ProjectDatabaseServerCallsAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListLoginProjects {

	public ListLoginProjects() {

		RootPanel.get().clear();
		RootPanel.get().add(new LoadingPanel());

		final ProjectDatabaseServerCallsAsync databaseServerCalls = GWT
				.create(ProjectDatabaseServerCalls.class);

		databaseServerCalls.listProjects(new AsyncCallback<List<Project>>() {

			public void onSuccess(List<Project> projects) {

				RootPanel.get().clear();
				RootPanel.get().add(new Login(projects));
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
