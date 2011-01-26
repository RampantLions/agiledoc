package sourceagile.planning.client.serverCalls;

import sourceagile.client.GWTStart;
import sourceagile.client.ProjectInitialization;
import sourceagile.planning.client.PlanningPage;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateProjectBacklog {

	final ProjectDatabaseServerCallsAsync databaseServerCalls = GWT
			.create(ProjectDatabaseServerCalls.class);

	public CreateProjectBacklog(ProjectBacklog projectBacklog) {

		databaseServerCalls.saveProjectBacklog(
				ProjectInitialization.currentProject.getProjectID(),
				projectBacklog, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						GWTStart.mainPage.panelContent.clear();
						GWTStart.mainPage.panelContent.add(new PlanningPage(
								ProjectInitialization.projectEntries));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}
}