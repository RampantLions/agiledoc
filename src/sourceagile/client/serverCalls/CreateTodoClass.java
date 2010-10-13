package sourceagile.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.client.userFeatures.specification.classViewOptions.OptionsIcons;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateTodoClass {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public CreateTodoClass(final ClassFile classFile) {

		remoteFunctions.createClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classFile, new AsyncCallback<Void>() {

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
