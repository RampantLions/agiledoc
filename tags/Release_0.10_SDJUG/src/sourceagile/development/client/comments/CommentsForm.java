package sourceagile.development.client.comments;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.form.TextArea;



/** 
 * Enable the team to storage comments and discussions in a very precise way for a specific part of the software. 
 * 
 * @UserManual 
 */
public class CommentsForm extends VerticalPanel {

	public static TextArea textAreaComment = new TextArea();

	public CommentsForm(Long projectID, String classPath) {

		this.setSpacing(5);

		Label labelSpace = new Label(" ");
		labelSpace.setHeight("70px");

		this.add(labelSpace);

		this.add(new Label("Comments: "));

		textAreaComment.setSize("400px", "60px");

		this.add(textAreaComment);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveComment(projectID, classPath));
	}

}
