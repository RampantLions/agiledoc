package com.agiledoc.client.view.search;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

/**
 * @todo
 * 
 * @author allineo
 * @modified 04/20/2010
 */
public class SearchIcon {

	/**
	 */
	public static Image getButton() {

		Image img = new Image("img/search.gif");
		img.setTitle("Search");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		return img;
	}
}
