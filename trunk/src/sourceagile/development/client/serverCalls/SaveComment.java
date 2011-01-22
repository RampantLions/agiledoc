package sourceagile.development.client.serverCalls;

import sourceagile.shared.entities.Comments;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCalls;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCallsAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveComment {

	final DatabaseAccessServerCallsAsync databaseServerCalls = GWT
			.create(DatabaseAccessServerCalls.class);

	public SaveComment(Comments comment) {

		databaseServerCalls.saveComment(comment, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {

			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});
	}

	private void updateProjectEntries(ClassFile entry) {

		for (int i = 0; i < ProjectInitialization.projectEntries.length; i++) {

			ClassFile classFile = ProjectInitialization.projectEntries[i];

			if (entry.compareTo(classFile) == 0) {

				ProjectInitialization.projectEntries[i] = entry;

				break;
			}
		}
	}
}
