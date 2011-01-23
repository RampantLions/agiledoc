package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.InternationalizationConstants;
import sourceagile.client.systemNavigation.FormField;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * First page of the system where the user can insert credentials.
 * 
 * TODO: Fix the error on the page entrance
 * 
 * @TODO
 */
public class LoginForm extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static ProjectList projectList;
	public static UsersList usersList = new UsersList();

	public LoginForm(List<Project> projects) {

		this.setSpacing(20);

		projectList = new ProjectList(projects);
		this.add(new FormField(internationalizationConstants.selectAProject(),
				projectList));

		this.add(new FormField(internationalizationConstants.user(), usersList));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonLogin());
	}
}
