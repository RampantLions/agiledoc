package sourceagile.client.serverCalls;

import java.util.ArrayList;

import sourceagile.client.GWTStart;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClasses;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClassesAsync;
import sourceagile.shared.entities.Productivity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListClassesHistory {

	private final LoadSubversionRemoteClassesAsync remoteFunctions = GWT
			.create(LoadSubversionRemoteClasses.class);

	public ListClassesHistory() {

		remoteFunctions.listHistory(ProjectInitialization.currentProject,
				GWTStart.currentUser,
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
