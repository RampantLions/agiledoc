package sourceagile.planning.client.serverCalls;

import sourceagile.client.ProjectInitialization;
import sourceagile.planning.client.PlanningPage;
import sourceagile.planning.client.projectBacklog.ProjectBacklogList;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListProjectBacklog {

	final GetProjectServerCallsAsync databaseServerCalls = GWT
			.create(GetProjectServerCalls.class);

	public ListProjectBacklog() {

		databaseServerCalls.getProject(
				ProjectInitialization.currentProject.getProjectID(),
				new AsyncCallback<Project>() {

					@Override
					public void onSuccess(Project project) {

						ProjectInitialization.currentProject = project;

						PlanningPage.vpProjectBacklog.clear();
						PlanningPage.vpProjectBacklog
								.add(new ProjectBacklogList());
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}
}