package sourceagile.client.systemNavigation.systemMenu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonPlanning extends Button {

	public ButtonPlanning() {

		setText("Planning");

		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

			}
		});
	}

}
