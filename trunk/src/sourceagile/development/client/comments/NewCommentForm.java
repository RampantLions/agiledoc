package sourceagile.development.client.comments;

import java.util.Date;

import sourceagile.client.SystemStart;
import sourceagile.development.client.serverCalls.SaveComment;
import sourceagile.shared.entities.Comments;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.form.TextArea;

public class NewCommentForm extends VerticalPanel {

	private TextArea textAreaComment = new TextArea();

	public NewCommentForm(Long projectID, String classPath) {

		this.add(new Label("Comments: "));

		textAreaComment.setSize("400px", "60px");

		this.add(textAreaComment);

		this.add(buttonSaveComment(projectID, classPath));
	}

	private Button buttonSaveComment(final Long projectID,
			final String classPath) {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new SaveComment(setComment(projectID, classPath));
			}
		});

		return button;
	}

	private Comments setComment(Long projectID, String classPath) {

		Comments comment = new Comments();

		comment.setCommentAuthor(SystemStart.currentUser.getName());
		comment.setCommentDate(new Date());
		comment.setCommentProject(projectID);
		comment.setCommentClass(classPath);
		comment.setCommentDescription(textAreaComment.getValueAsString());

		return comment;
	}
}
