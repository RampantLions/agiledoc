package sourceagile.client.serverConnection;

import java.util.ArrayList;

import sourceagile.client.SystemStart;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.Productivity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListClassesHistory {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public ListClassesHistory() {

		remoteFunctions.ListHistory(ProjectInitialization.currentProject,
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
