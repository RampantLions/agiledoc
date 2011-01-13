package sourceagile.planning.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.planning.client.PlanningPage;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.userprojects.client.ProjectInitialization;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCalls;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCallsAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateProjectBacklog {

	final DatabaseAccessServerCallsAsync databaseServerCalls = GWT
			.create(DatabaseAccessServerCalls.class);

	public CreateProjectBacklog(ProjectBacklog projectBacklog) {

		databaseServerCalls.saveProjectBacklog(
				ProjectInitialization.currentProject.getProjectID(),
				projectBacklog, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						SystemStart.mainPage.panelContent.clear();
						SystemStart.mainPage.panelContent.add(new PlanningPage(
								ProjectInitialization.projectEntries));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}
}