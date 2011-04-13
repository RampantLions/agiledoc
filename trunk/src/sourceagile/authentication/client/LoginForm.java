package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * 
 * @UserManual
 */
public class LoginForm extends HorizontalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static TextBox fieldEmail = new TextBox();

	public static PasswordTextBox fieldPassword = new PasswordTextBox();

	public static ProjectList projectList;

	public LoginForm(List<Project> projects) {

		this.setSpacing(10);

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(logoPanel());

		fieldEmail.setWidth("200px");

		this.add(FormField.getVerticalFormField(
				internationalizationConstants.user(), "70px", fieldEmail));

		fieldPassword.setWidth("200px");

		this.add(FormField.getVerticalFormField(
				internationalizationConstants.password(), "70px", fieldPassword));

		projectList = new ProjectList(projects);

		this.add(FormField.getVerticalFormField(
				internationalizationConstants.selectAProject(), "150px",
				projectList));

		this.add(new ButtonLogin());
		this.add(new ButtonNewProject());
	}

	private HTML logoPanel() {

		HTML html = new HTML(
				"<center><b><font size=6 color=orange>LIVE SOURCE</font>"
						+ "<font size=5><br>Agile Toolkit</font></b> "
						+ "<br><br><font size=4>"
						+ GlobalVariables.systemVersion + "</font></center>");

		html.setWidth("350px");

		return html;
	}

}
