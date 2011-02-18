package sourceagile.authentication.client;

import sourceagile.authentication.client.serverCalls.Login;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.User;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonLogin extends Button {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonLogin() {

		this.setText(internationalizationConstants.logIn());

		this.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				User userLog = new User();

				userLog.setEmail(LoginForm.fieldEmail.getValue());
				userLog.setPassword(LoginForm.fieldPassword.getValue());

				Long projectSelected = new Long(
						ProjectSelectionPanel.projectList
								.getValue(ProjectSelectionPanel.projectList
										.getSelectedIndex()));

				new Login(userLog, projectSelected);
			}
		});
	}
}
