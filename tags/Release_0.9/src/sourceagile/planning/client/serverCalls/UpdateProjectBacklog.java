package sourceagile.planning.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.planning.client.PlanningPage;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.shared.utilities.LoadingPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class UpdateProjectBacklog {

	final ProjectBacklogServerCallsAsync databaseServerCalls = GWT
			.create(ProjectBacklogServerCalls.class);

	public UpdateProjectBacklog(ProjectBacklog projectBacklog) {

		GlobalVariables.mainPage.panelContent.add(new LoadingPanel());
		GlobalVariables.mainPage.panelContent.clear();

		databaseServerCalls.updateProjectBacklog(
				ProjectInitialization.currentProject.getProjectID(),
				projectBacklog, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						GlobalVariables.mainPage.panelContent.clear();
						GlobalVariables.mainPage.panelContent
								.add(new PlanningPage(
										ProjectInitialization.projectEntries));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}
}