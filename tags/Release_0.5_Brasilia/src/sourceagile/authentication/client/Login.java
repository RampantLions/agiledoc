package sourceagile.authentication.client;

import java.util.List;

import sourceagile.authentication.client.serverCalls.GetLoginProject;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.SystemStart;
import sourceagile.client.systemNavigation.FormField;
import sourceagile.shared.data.UserData;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.ProjectList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public Login(List<Project> projects) {

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

		this.add(panelLogin(projects));

	}

	private VerticalPanel panelLogin(List<Project> projects) {

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(20);

		final ProjectList projectList = new ProjectList(projects);
		vp.add(new FormField(internationalizationConstants.selectAProject(),
				projectList));

		final UsersList usersList = new UsersList();
		vp.add(new FormField(internationalizationConstants.user(), usersList));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Button button = new Button(internationalizationConstants.logIn(),
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						User userSelected = UserData.load()[Integer
								.parseInt(usersList.getValue(usersList
										.getSelectedIndex()))];

						SystemStart.currentUser = userSelected;

						Long projectSelected = new Long(projectList
								.getValue(projectList.getSelectedIndex()));

						new GetLoginProject(projectSelected);
					}
				});

		vp.add(button);

		return vp;

	}
}
