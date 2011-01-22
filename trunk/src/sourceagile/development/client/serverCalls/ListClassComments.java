package sourceagile.development.client.serverCalls;

import java.util.List;

import sourceagile.development.client.comments.CommentsList;
import sourceagile.development.client.comments.NewCommentForm;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.shared.entities.Comments;
import sourceagile.userprojects.client.ProjectInitialization;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCalls;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCallsAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListClassComments {

	final DatabaseAccessServerCallsAsync databaseServerCalls = GWT
			.create(DatabaseAccessServerCalls.class);

	public ListClassComments(final String classPath) {

		databaseServerCalls.listComments(
				ProjectInitialization.currentProject.getProjectID(), classPath,
				new AsyncCallback<List<Comments>>() {

					public void onSuccess(List<Comments> comments) {

						FeatureDescription.vpComments.clear();
						
						FeatureDescription.vpComments.add(new NewCommentForm(
								ProjectInitialization.currentProject
										.getProjectID(), classPath));

						FeatureDescription.vpComments.add(new CommentsList(
								comments));
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}
}
