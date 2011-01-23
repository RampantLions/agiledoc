package sourceagile.authentication.client;

import sourceagile.authentication.client.serverCalls.GetLoginProject;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.SystemStart;
import sourceagile.shared.data.UserData;
import sourceagile.shared.entities.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * First page of the system where the user can insert credentials.
 * 
 * TODO: Fix the error on the page entrance
 * 
 * @TODO
 */
public class ButtonLogin extends Button {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonLogin() {

		this.setText(internationalizationConstants.logIn());

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				User userSelected = UserData.load()[Integer
						.parseInt(LoginForm.usersList
								.getValue(LoginForm.usersList
										.getSelectedIndex()))];

				SystemStart.currentUser = userSelected;

				Long projectSelected = new Long(LoginForm.projectList
						.getValue(LoginForm.projectList.getSelectedIndex()));

				new GetLoginProject(projectSelected);
			}
		});
	}
}
