package com.agiledoc.client.view.search;

import com.agiledoc.client.view.root.IconChangeRoot;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/20/2010
 */
public class PanelOptions {

	/**
	 * Show a panel with the root and domain string to be changed by the user.
	 * 
	 * @author allineo
	 * @modified 04/20/2010
	 * @link com.gwtjavadoc.client.view.components.ButtonChangeSystemRoot
	 */
	public static HorizontalPanel show() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(5);
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		final TextBox text = new TextBox();
		text.setWidth("130");
		hp.add(text);

		hp.add(SearchIcon.getButton());

		hp.add(IconChangeRoot.getImage());

		return hp;
	}

}
