package sourceagile.development.client.comments;

import java.util.Date;

import sourceagile.client.GlobalVariables;
import sourceagile.development.client.serverCalls.SaveComment;
import sourceagile.shared.entities.Comments;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * 
 * @UserManual
 */
public class ButtonSaveComment extends Button {

	public ButtonSaveComment(final Long projectID, final String classPath) {

		this.setText("Save");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new SaveComment(setComment(projectID, classPath));
			}
		});
	}

	private Comments setComment(Long projectID, String classPath) {

		Comments comment = new Comments();

		comment.setCommentAuthor(GlobalVariables.currentUser.getName());
		comment.setCommentDate(new Date());
		comment.setCommentProject(projectID);
		comment.setCommentClass(classPath);
		comment.setCommentDescription(CommentsForm.textAreaComment
				.getValueAsString());

		return comment;
	}
}
