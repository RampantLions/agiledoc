package sourceagile.development.client.comments;

import java.util.List;

import sourceagile.shared.entities.Comments;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @Feature
 */
public class CommentsList extends VerticalPanel {

	public CommentsList(List<Comments> comments) {

		for (Comments comment : comments) {

			this.add(showComment(comment));
		}
	}

	public static HTML showComment(Comments comment) {

		String commentDate = "<B><FONT SIZE=2>"
				+ comment.getCommentDate().toString() + "</FONT></B>";

		String commentAuthor = "<B><FONT SIZE=2> - "
				+ comment.getCommentAuthor() + "</FONT></B><BR>";

		HTML html = new HTML(commentDate + commentAuthor
				+ comment.getCommentDescription());
		html.setWidth("400px");

		return html;
	}

}
