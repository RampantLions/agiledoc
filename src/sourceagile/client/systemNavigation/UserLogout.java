package sourceagile.client.systemNavigation;

import sourceagile.administration.client.Administration;
import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.form.Label;

public class UserLogout extends HorizontalPanel {

	public UserLogout() {

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.setSpacing(3);

		HTML userName = new HTML("<font size=1 color=blue>" + getUserName()
				+ " | ");

		this.add(userName);

		if (User.ADMIN_USER.equals(GlobalVariables.currentUser.getName())) {

			HTML administrationLink = new HTML(
					" <font size=1 color=blue><a href='#'>Administration</a> | </font>");
			administrationLink.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					RootPanel.get("htmlID").clear();
					RootPanel.get("htmlID").add(new Administration());
				}
			});

			this.add(administrationLink);
		}

		HTML userLogoutHTML = new HTML(" <font size=1 color=blue><a href='"
				+ GWT.getHostPageBaseURL() + "'>Logout</a></font>");

		this.add(userLogoutHTML);

		Label space = new Label(" ");
		space.setWidth("10px");

		this.add(space);
	}

	private String getUserName() {

		String userName = GlobalVariables.currentUser.getName();
		if (userName == null) {

			userName = GlobalVariables.currentUser.getEmail();
		}

		if (userName == null) {

			userName = "Public";
		}

		return userName;
	}
}
