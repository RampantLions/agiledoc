package sourceagile.client.authentication;

import sourceagile.client.SystemStart;
import sourceagile.client.systemNavigation.FormField;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.Project;
import sourceagile.shared.User;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.data.UserData;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends VerticalPanel {

	public Login() {

		this.setSize("100%", "100%");

		this.setSpacing(60);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(new Label(" "));

		this.add(new HTML(
				"<center><font size=5>Welcome to </font>"
						+ "<br><br><b><font size=6>The Source Code Agile Experiment</b> "
						+ "<br><br><b>an Agile Toolkit</font></b> "
						+ "<br><br><br><font size=4>Prototype Version</font></center>"));

		this.add(panelLogin());

	}

	private VerticalPanel panelLogin() {

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(20);

		final ProjectList projectList = new ProjectList();
		vp.add(new FormField("Select a Project", projectList));

		final UsersList usersList = new UsersList();
		vp.add(new FormField("and User", usersList));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Button button = new Button("Log in", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				User userSelected = UserData.load()[Integer.parseInt(usersList
						.getValue(usersList.getSelectedIndex()))];

				SystemStart.currentUser = userSelected;

				Project projectSelected = ProjectsData.load()[Integer
						.parseInt(usersList.getValue(usersList
								.getSelectedIndex()))];

				new ProjectInitialization(projectSelected);
			}
		});

		vp.add(button);

		return vp;

	}
}
