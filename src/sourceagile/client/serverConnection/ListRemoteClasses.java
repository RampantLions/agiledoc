package sourceagile.client.serverConnection;

import sourceagile.client.SystemInitialization;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListRemoteClasses {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public ListRemoteClasses() {

		remoteFunctions.ListFeatures(ProjectInitialization.currentProject,
				SystemInitialization.currentUser, new AsyncCallback<Entry[]>() {

					public void onSuccess(Entry[] entries) {

						ProjectInitialization.projectEntries = entries;

						RootPanel.get().clear();
						RootPanel.get().add(SystemInitialization.mainPage);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
