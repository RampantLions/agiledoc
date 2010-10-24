package sourceagile.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.ClassFile;
import sourceagile.shared.utilities.FileNameGenerator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateTodoClass {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

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

						new GetRemoteClass(classFile,
								OptionsIcons.OPTION_DESCRIPTION);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
