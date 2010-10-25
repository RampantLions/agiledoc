package sourceagile.client.serverCalls;

import java.util.ArrayList;

import sourceagile.client.SystemStart;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.Productivity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListClassesHistory {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public ListClassesHistory() {

		remoteFunctions.listHistory(ProjectInitialization.currentProject,
				SystemStart.currentUser,
				new AsyncCallback<ArrayList<Productivity>>() {

					public void onSuccess(
							ArrayList<Productivity> produtctivityArray) {

						ProjectInitialization.projectActivity = produtctivityArray;
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
