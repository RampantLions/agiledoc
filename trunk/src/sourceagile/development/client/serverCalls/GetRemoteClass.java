package sourceagile.development.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.client.serverCalls.LoadRemoteClassesAsync;
import sourceagile.development.client.Development;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.LoadingPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetRemoteClass {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public GetRemoteClass(ClassFile classfile, final int viewOption) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.getClass(ProjectInitialization.currentProject,
				GlobalVariables.currentUser, classfile,
				new AsyncCallback<ClassFile>() {

					public void onSuccess(ClassFile entry) {

						ProjectInitialization.projectEntries.put(
								entry.toString(), entry);

						Development.showClass(entry, viewOption);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}
}
