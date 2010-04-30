package com.agiledoc.client.view.main;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TopPanel {

	/**
	 * Show the main options for the system.
	 * 
	 * @link com.gwtjavadoc.client.view.components.ButtonChangeSystemRoot
	 * @link com.gwtjavadoc.client.view.main.ViewOptions
	 */
	public static HorizontalPanel show() {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSize("100%", "20");
		hp.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		hp.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

		hp.add(SystemViews.getViewOptions());

		hp.add(PanelOptions.show());

		return hp;
	}

}
