package sourceagile.client.serverCalls.test;

import sourceagile.client.SystemStart;
import sourceagile.client.serverCalls.GetRemoteClass;
import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Create a Test Class for the new To Do Class that is being created by the
 * user.
 */
public class AddTestClass {

	private final LoadRemoteTestClassesAsync remoteFunctions = GWT
			.create(LoadRemoteTestClasses.class);

	public AddTestClass(final ClassFile classFile) {

		this(classFile, false);
	}

	public AddTestClass(final ClassFile classFile, final boolean newTask) {

		remoteFunctions.addTestClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classFile, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						if (!newTask) {

							new GetRemoteClass(classFile,
									OptionsIcons.OPTION_DESCRIPTION);
						}
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
