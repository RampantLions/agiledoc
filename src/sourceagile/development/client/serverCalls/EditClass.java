package sourceagile.development.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.client.serverCalls.LoadRemoteClassesAsync;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.LoadingPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EditClass {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public EditClass(final ClassFile classFile, String classDescription) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.editClass(ProjectInitialization.currentProject,
				GlobalVariables.currentUser, classFile, classDescription,
				new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						new GetRemoteClass(classFile,
								OptionsIcons.OPTION_DESCRIPTION);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
