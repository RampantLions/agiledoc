package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.SystemStart;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * First page of the system where the user can insert credentials.
 * 
 * TODO: Fix the error on the page entrance
 * 
 * @TODO
 * @UserManual
 */
public class LoginPage extends VerticalPanel {

	public LoginPage(List<Project> projects) {

		this.setSize("100%", "100%");

		this.setSpacing(60);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(new Label(" "));

		this.add(new HTML("<center><font size=5>Welcome to </font>"
				+ "<br><br><b><font size=6>The Source Agile Toolkit</b> "
				+ "<br><br><font size=4>" + SystemStart.systemVersion
				+ "</font></center>"));

		this.add(new LoginForm(projects));
	}
}
