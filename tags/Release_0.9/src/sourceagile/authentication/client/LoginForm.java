package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * 
 * @UserManual
 */
public class LoginForm extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static TextBox fieldEmail = new TextBox();

	public static PasswordTextBox fieldPassword = new PasswordTextBox();

	public LoginForm(List<Project> projects) {

		this.setSpacing(10);

		fieldEmail.setWidth("200px");

		this.add(new FormField(internationalizationConstants.user(), "70px",
				fieldEmail));

		fieldPassword.setWidth("200px");

		this.add(new FormField(internationalizationConstants.password(),
				"70px", fieldPassword));
	}
}
