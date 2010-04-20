package com.agiledoc.client.view.main;

import com.agiledoc.client.view.search.PanelOptions;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/20/2010
 */
public class TopPanel {

	/**
	 * Show the main options for the system.
	 * 
	 * @author allineo
	 * @modified 04/20/2010
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
