package sourceagile.client.serverConnection;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateTodoClass {

	private final RemoteLoadFunctionsAsync remoteFunctions = GWT
			.create(RemoteLoadFunctions.class);

	public CreateTodoClass(ClassFile classFile) {

		remoteFunctions.createClasse(ProjectInitialization.currentProject,
				classFile, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {

						new ListRemoteClasses();
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
