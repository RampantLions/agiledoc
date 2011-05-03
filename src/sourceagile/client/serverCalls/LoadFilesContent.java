package sourceagile.client.serverCalls;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoadFilesContent {

	private final LoadRemoteClassesAsync remoteFunctions = GWT
			.create(LoadRemoteClasses.class);

	public LoadFilesContent() {

		for (ClassFile entry : ProjectInitialization.projectEntries.values()) {

			if (ClassFile.EXTENSION_FEATURE.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_JAVA
							.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_JSP.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_CSS.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_HTML
							.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_XML.equals(entry.getFileExtension())) {

				remoteFunctions.getClass(ProjectInitialization.currentProject,
						GlobalVariables.currentUser, entry,
						new AsyncCallback<ClassFile>() {

							public void onSuccess(ClassFile classFile) {

								ProjectInitialization.projectEntries.put(
										classFile.toString(), classFile);

							}

							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user

							}
						});
			}
		}
	}
}
