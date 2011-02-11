package sourceagile.client.systemNavigation;

import sourceagile.client.GlobalVariables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class UserLogout extends HorizontalPanel {

	public UserLogout() {

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		String logout = "<a href='" + GWT.getHostPageBaseURL() + "'>Logout</a>";

		HTML userLogoutHTML = new HTML("<font size=1 color=blue>"
				+ getUserName() + " | " + logout + "</font>");

		userLogoutHTML.setAutoHorizontalAlignment(ALIGN_CENTER);
		userLogoutHTML.setWidth("200px");

		this.add(userLogoutHTML);
	}

	private String getUserName() {

		String userName = GlobalVariables.userLoggedIn.getName();
		if (userName == null) {

			userName = GlobalVariables.userLoggedIn.getEmail();
		}

		if (userName == null || userName.equals("")) {

			userName = "Public";
		}

		return userName;
	}
}
