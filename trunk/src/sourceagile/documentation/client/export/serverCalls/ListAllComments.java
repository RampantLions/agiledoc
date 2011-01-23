package sourceagile.documentation.client.export.serverCalls;

import java.util.HashMap;

import sourceagile.development.client.serverCalls.CommentsServerCalls;
import sourceagile.development.client.serverCalls.CommentsServerCallsAsync;
import sourceagile.shared.entities.Comments;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListAllComments {

	final CommentsServerCallsAsync commentsServerCalls = GWT
			.create(CommentsServerCalls.class);

	public ListAllComments() {

		commentsServerCalls.listAllComments(
				ProjectInitialization.currentProject.getProjectID(),
				new AsyncCallback<HashMap<String, Comments>>() {

					public void onSuccess(HashMap<String, Comments> comments) {

					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}
}
