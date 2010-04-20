package com.agiledoc.client.view.root;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class RootPanel {

	/**
	 * Show a panel with the root and domain string to be changed by the user.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 * @link com.gwtjavadoc.client.view.components.ButtonChangeSystemRoot
	 */
	public static HorizontalPanel show() {

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
