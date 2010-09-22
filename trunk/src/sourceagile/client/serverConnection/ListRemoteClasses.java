package sourceagile.client.serverConnection;

import sourceagile.client.SystemInitialization;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListRemoteClasses {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public ListRemoteClasses() {

		RootPanel.get().clear();
		RootPanel.get().add(new LoadingPanel());

		remoteFunctions.ListFeatures(ProjectInitialization.currentProject,
				SystemInitialization.currentUser,
				new AsyncCallback<ClassFile[]>() {

					public void onSuccess(ClassFile[] entries) {

						ProjectInitialization.projectEntries = entries;

						SystemInitialization.mainPage = new MainPage();

						RootPanel.get().clear();
						RootPanel.get().add(SystemInitialization.mainPage);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
