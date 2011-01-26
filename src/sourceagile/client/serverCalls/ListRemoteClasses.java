package sourceagile.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClasses;
import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClassesAsync;
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

			listRemoteClassesFromSubversion();

		} else {

			listRemoteClassesFromGit();
		}

	}

	private void listRemoteClassesFromSubversion() {

		final LoadRemoteClassesAsync subversionRemoteFunctions = GWT
				.create(LoadRemoteClasses.class);

		subversionRemoteFunctions.listClasses(
				ProjectInitialization.currentProject,
				GlobalVariables.currentUser, new AsyncCallback<ClassFile[]>() {

					public void onSuccess(ClassFile[] entries) {

						ProjectInitialization.projectEntries = entries;

						GlobalVariables.mainPage = new MainPage();

						RootPanel.get("htmlID").clear();
						RootPanel.get("htmlID").add(GlobalVariables.mainPage);

						new ListComponentClasses();
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}

	private void listRemoteClassesFromGit() {

		final LoadGitRemoteClassesAsync gitRemoteFunctions = GWT
				.create(LoadGitRemoteClasses.class);

		gitRemoteFunctions.listClasses(ProjectInitialization.currentProject,
				GlobalVariables.currentUser, new AsyncCallback<ClassFile[]>() {

					public void onSuccess(ClassFile[] entries) {

						ProjectInitialization.projectEntries = entries;

						GlobalVariables.mainPage = new MainPage();

						RootPanel.get("htmlID").clear();
						RootPanel.get("htmlID").add(GlobalVariables.mainPage);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}

}
