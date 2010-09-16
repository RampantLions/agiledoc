package sourceagile.client.systemNavigation.systemMenu;

import sourceagile.client.activity.ActivityPage;
import sourceagile.client.systemNavigation.MainPage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonActivity extends Button {

	public ButtonActivity() {

		setText("Activity");

		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				MainPage.panelContent.clear();
				MainPage.panelContent.add(new ActivityPage());
			}
		});
	}

}
