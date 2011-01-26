package sourceagile.authentication.client.serverCalls;

import java.util.List;

import sourceagile.authentication.client.LoginPage;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListProjects {

	public ListProjects() {

		RootPanel.get("htmlID").clear();
		RootPanel.get("htmlID").add(new LoadingPanel());

		final AuthenticationServerCallsAsync databaseServerCalls = GWT
				.create(AuthenticationServerCalls.class);

		databaseServerCalls.listProjects(new AsyncCallback<List<Project>>() {

			public void onSuccess(List<Project> projects) {

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(new LoginPage(projects));
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
