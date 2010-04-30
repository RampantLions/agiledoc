package com.agiledoc.client.view.main;

import com.agiledoc.client.view.project.ChangeProjectPage;
import com.agiledoc.client.view.search.SearchIcon;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

public class PanelOptions {

	/**
	 * Show a panel with the root and domain string to be changed by the user.
	 * 
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

		hp.add(getChangeProjectIcon());

		return hp;
	}

	/**
	 * Return the button widget that implements the Change Root functionality on
	 * the click event. After the click the system will start again with the new
	 * root and domain selected.
	 * 
	 * @link com.gwtjavadoc.client.control.ListSourceClasses
	 */
	public static Image getChangeProjectIcon() {

		Image img = new Image("img/chart_organisation.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ChangeProjectPage.init();
			}
		});

		img.setTitle("Change Project");

		return img;
	}

}
