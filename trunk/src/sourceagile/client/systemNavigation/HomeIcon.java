package sourceagile.client.systemNavigation;

import sourceagile.client.GlobalVariables;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @UserManual
 */
public class HomeIcon extends HTML {

	public HomeIcon() {

		this.setHTML("<a href='#'><img src='images/home.gif'></a>");

		this.setTitle("Project Home");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage = new MainPage();

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(GlobalVariables.mainPage);
			}
		});
	}
}
