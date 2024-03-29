package sourceagile.development.client.serverCalls;

import java.util.List;

import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.comments.CommentsList;
import sourceagile.development.client.comments.CommentsForm;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.shared.entities.Comments;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListClassComments {

	final CommentsServerCallsAsync commentsServerCalls = GWT
			.create(CommentsServerCalls.class);

	public ListClassComments(final String classPath) {

		commentsServerCalls.listClassComments(
				ProjectInitialization.currentProject.getProjectID(), classPath,
				new AsyncCallback<List<Comments>>() {

					public void onSuccess(List<Comments> comments) {

						FeatureDescription.vpComments.clear();

						FeatureDescription.vpComments.add(new CommentsForm(
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
