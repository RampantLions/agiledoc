package sourceagile.authentication.client;

import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * 
 * @UserManual
 */
public class LoginForm extends VerticalPanel {

	public static TextBox fieldEmail = new TextBox();

	public static PasswordTextBox fieldPassword = new PasswordTextBox();

	public LoginForm(List<Project> projects) {

		this.setSpacing(10);

		fieldEmail.setWidth("200px");

		this.add(new FormField("Email", "60px", fieldEmail));

		fieldPassword.setWidth("200px");

		this.add(new FormField("Password", "60px", fieldPassword));
	}
}
