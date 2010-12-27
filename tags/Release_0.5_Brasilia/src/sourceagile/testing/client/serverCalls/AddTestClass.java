package sourceagile.testing.client.serverCalls;

import sourceagile.client.SystemStart;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;

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

		this(classFile, null, false);
	}

	public AddTestClass(final ClassFile classFile, String newSubfolderName,
			final boolean newTask) {

		remoteFunctions.addTestClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classFile, newSubfolderName,
				new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						if (!newTask) {

							new GetRemoteTestClass(classFile,
									OptionsIcons.OPTION_TEST);
						}
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
