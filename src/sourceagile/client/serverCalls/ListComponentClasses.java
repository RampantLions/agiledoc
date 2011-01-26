package sourceagile.client.serverCalls;

import java.util.HashMap;

import sourceagile.client.GWTStart;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClasses;
import sourceagile.client.serverCalls.subversionRepository.LoadSubversionRemoteClassesAsync;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListComponentClasses {

	private static LoadSubversionRemoteClassesAsync subversionRemoteFunctions = GWT
			.create(LoadSubversionRemoteClasses.class);

	public ListComponentClasses() {

		for (final ProjectComponents component : ProjectInitialization.currentProject
				.getProjectComponents()) {

			subversionRemoteFunctions.listComponentClasses(
					ProjectInitialization.currentProject,
					GWTStart.currentUser, component.getComponentPath(),
					new AsyncCallback<HashMap<String, ClassFile>>() {

						public void onSuccess(HashMap<String, ClassFile> entries) {

							for (int i = 0; i < ProjectInitialization.projectEntries.length; i++) {

								ClassFile projectClass = ProjectInitialization.projectEntries[i];

								if (projectClass.getFilePath().startsWith(
										component.getComponentPath())) {

									ProjectInitialization.projectEntries[i] = entries
											.get(projectClass.toString());
								}
							}
						}

						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user

						}

					});
		}
	}
}
