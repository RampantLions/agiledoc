package sourceagile.client.serverCalls;

import java.util.HashMap;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListComponentClasses {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public ListComponentClasses() {

		for (final ProjectComponents component : ProjectInitialization.currentProject
				.getProjectComponents()) {

			remoteFunctions.listComponentClasses(
					ProjectInitialization.currentProject,
					GlobalVariables.currentUser, component.getComponentPath(),
					new AsyncCallback<HashMap<String, ClassFile>>() {

						public void onSuccess(
								HashMap<String, ClassFile> classComponent) {

							for (ClassFile classFileComponent : classComponent
									.values()) {

								String entryKey = ProjectInitialization.currentProject
										.getRepositoryURL()
										+ "/"
										+ classFileComponent.toString();

								ProjectInitialization.projectEntries.put(
										entryKey, classFileComponent);
							}
						}

						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user

						}
					});
		}
	}
}
