package sourceagile.authentication.client;

import sourceagile.authentication.client.serverCalls.Login;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * 
 * 
 * @UserManual
 */
public class ButtonLogin extends Button {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonLogin() {

		this.setText(internationalizationConstants.logIn());

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				User userLog = new User();

				userLog.setName(LoginForm.fieldEmail.getValue());
				userLog.setPassword(LoginForm.fieldPassword.getValue());

				Long projectSelected = new Long(LoginForm.projectList
						.getValue(LoginForm.projectList.getSelectedIndex()));

				new Login(userLog, projectSelected);
			}
		});
	}
}
