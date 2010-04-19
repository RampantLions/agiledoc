package com.agiledoc.client.view.main.topPanel;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class TopPanel {

	/**
	 * Show the main options for the system.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 * 
	 * @link com.gwtjavadoc.client.view.components.ButtonChangeSystemRoot
	 * @link com.gwtjavadoc.client.view.main.ViewOptions
	 */
	public static HorizontalPanel show() {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSize("100%", "10");
		hp.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		hp.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

		hp.add(ShowChangeRootPanel());

		hp.add(SystemViews.getViewOptions());

		return hp;
	}

	/**
	 * Show a panel with the root and domain string to be changed by the user.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 * @link com.gwtjavadoc.client.view.components.ButtonChangeSystemRoot
	 */
	private static HorizontalPanel ShowChangeRootPanel() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(5);

		final TextBox root = new TextBox();
		root.setWidth("300");
		root.setValue(GlobalVariables.getROOT());
		hp.add(root);

		final TextBox pack = new TextBox();
		pack.setWidth("200");
		pack.setValue(GlobalVariables.getPACK());
		hp.add(pack);

		hp.add(ButtonChangeRoot.getButton(root.getValue(), pack.getValue()));

		return hp;
	}

}
