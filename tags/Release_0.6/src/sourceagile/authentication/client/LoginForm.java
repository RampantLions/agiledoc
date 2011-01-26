package sourceagile.authentication.client;

import helpagile.client.exportation.HelpWindow;

import java.util.List;

import sourceagile.client.InternationalizationConstants;
import sourceagile.client.systemNavigation.FormField;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * 
 * @UserManual
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

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HorizontalPanel hp = new HorizontalPanel();

		hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		hp.setWidth("350px");

		hp.add(new ButtonLogin());

		hp.add(HelpWindow.helpLink("SourceAgile", "false", "Read more"));

		this.add(hp);
	}
}
