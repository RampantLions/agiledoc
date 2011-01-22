package sourceagile.userprojects.client.serverCalls;

import java.util.List;

import sourceagile.client.SystemStart;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectSelection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class ListProjects {

	public ListProjects() {

		final ProjectDatabaseServerCallsAsync databaseServerCalls = GWT
				.create(ProjectDatabaseServerCalls.class);

		databaseServerCalls.listProjects(new AsyncCallback<List<Project>>() {

			public void onSuccess(List<Project> projects) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				SystemStart.mainPage.panelContent.add(new ProjectSelection(
						projects));
				SystemStart.mainPage.panelContent
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
