package sourceagile.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClasses;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClassesAsync;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateTodoClass {

	private final LoadSubversionRemoteClassesAsync remoteFunctions = GWT
			.create(LoadSubversionRemoteClasses.class);

	public CreateTodoClass(final ClassFile classFile, final String newSubfolder) {

		remoteFunctions.createClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classFile, newSubfolder,
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