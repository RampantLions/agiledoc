package agiledoc.client.navigation.systemMenu;

import agiledoc.client.features.FeaturesPage;
import agiledoc.client.navigation.MainPage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonFeatures extends Button {

	public ButtonFeatures() {

		setText("Features");

		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				MainPage.panelSystemContent.clear();
				MainPage.panelSystemContent.add(new FeaturesPage());
			}
		});
	}

}
