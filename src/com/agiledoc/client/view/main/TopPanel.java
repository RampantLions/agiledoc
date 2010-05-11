package com.agiledoc.client.view.main;

import com.agiledoc.client.view.SystemMenu;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TopPanel {

	/**
	 * Show the main options for the system.
	 */
	public static HorizontalPanel show() {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSize("100%", "20");
		hp.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		hp.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

		hp.add(new SystemMenu());

		hp.add(PanelOptions.show());

		return hp;
	}

}
