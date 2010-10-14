package sourceagile.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListRemoteClasses {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public ListRemoteClasses() {

		RootPanel.get().clear();
		RootPanel.get().add(new LoadingPanel());

		remoteFunctions.listClasses(ProjectInitialization.currentProject,
				SystemStart.currentUser, new AsyncCallback<ClassFile[]>() {

					public void onSuccess(ClassFile[] entries) {

						ProjectInitialization.projectEntries = entries;

						SystemStart.mainPage = new MainPage();

						RootPanel.get().clear();
						RootPanel.get().add(SystemStart.mainPage);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
