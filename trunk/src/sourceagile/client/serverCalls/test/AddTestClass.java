package sourceagile.client.serverCalls.test;

import sourceagile.client.SystemStart;
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

	public AddTestClass(ClassFile classFile) {

		remoteFunctions.addTestClass(ProjectInitialization.currentProject,
				SystemStart.currentUser, classFile, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						// new ListRemoteClasses();
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
