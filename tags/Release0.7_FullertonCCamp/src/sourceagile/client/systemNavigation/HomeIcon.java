package sourceagile.client.systemNavigation;

import sourceagile.client.GlobalVariables;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @UserManual
 */
public class HomeIcon {

	public static Image getImage() {

		Image img = new Image("images/home.gif");

		img.setTitle("Project Home");

		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage = new MainPage();

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(GlobalVariables.mainPage);
			}
		});

		return img;
	}

}
