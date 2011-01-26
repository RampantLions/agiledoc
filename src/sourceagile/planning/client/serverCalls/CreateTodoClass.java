package sourceagile.planning.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.client.serverCalls.LoadRemoteClassesAsync;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateTodoClass {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public CreateTodoClass(final ClassFile classFile, final String newSubfolder) {

		remoteFunctions.createClass(ProjectInitialization.currentProject,
				GlobalVariables.currentUser, classFile, newSubfolder,
				new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						if (newSubfolder != null && newSubfolder.length() > 0) {

							classFile.setFilePath(classFile.getFilePath() + "/"
									+ newSubfolder);

							classFile.getClassDoc().setClassPackage(
									classFile.getClassDoc().getClassPackage()
											+ "." + newSubfolder);
						}

						// new GetRemoteClass(classFile,
						// OptionsIcons.OPTION_DESCRIPTION);

						new ProjectInitialization(
								ProjectInitialization.currentProject);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}