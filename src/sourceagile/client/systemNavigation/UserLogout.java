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

		HTML userName = new HTML("<font size=1 color=blue>"
				+ GlobalVariables.currentUser.getName() + " | " + logout
				+ "</font>");

		userName.setAutoHorizontalAlignment(ALIGN_CENTER);
		userName.setWidth("200px");

		this.add(userName);
	}
}
