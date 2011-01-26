package sourceagile.development.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClasses;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClassesAsync;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EditClass {

	private final LoadSubversionRemoteClassesAsync remoteFunctions = GWT
			.create(LoadSubversionRemoteClasses.class);

	public EditClass(final ClassFile classFile, String classDescription) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel.add(new LoadingPanel());

		remoteFunctions.editClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classFile, classDescription,
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
