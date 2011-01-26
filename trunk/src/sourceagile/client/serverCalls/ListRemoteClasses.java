package sourceagile.client.serverCalls;

import sourceagile.client.GWTStart;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClasses;
import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClassesAsync;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClasses;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClassesAsync;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class ListRemoteClasses {

	public ListRemoteClasses() {

		RootPanel.get("htmlID").clear();
		RootPanel.get("htmlID").add(new LoadingPanel());

		if (Project.REPOSITORY_TYPE_SUBVERSION
				.equals(ProjectInitialization.currentProject
						.getRepositoryType())) {

			final LoadSubversionRemoteClassesAsync subversionRemoteFunctions = GWT
					.create(LoadSubversionRemoteClasses.class);

			subversionRemoteFunctions.listClasses(
					ProjectInitialization.currentProject,
					GWTStart.currentUser, new AsyncCallback<ClassFile[]>() {

						public void onSuccess(ClassFile[] entries) {

							ProjectInitialization.projectEntries = entries;

							GWTStart.mainPage = new MainPage();

							RootPanel.get("htmlID").clear();
							RootPanel.get("htmlID").add(GWTStart.mainPage);

							new ListComponentClasses();
						}

						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user

						}

					});

		} else {

			final LoadGitRemoteClassesAsync gitRemoteFunctions = GWT
					.create(LoadGitRemoteClasses.class);

			gitRemoteFunctions.listClasses(
					ProjectInitialization.currentProject,
					GWTStart.currentUser, new AsyncCallback<ClassFile[]>() {

						public void onSuccess(ClassFile[] entries) {

							ProjectInitialization.projectEntries = entries;

							GWTStart.mainPage = new MainPage();

							RootPanel.get("htmlID").clear();
							RootPanel.get("htmlID").add(GWTStart.mainPage);
						}

						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user

						}

					});
		}

	}

}
