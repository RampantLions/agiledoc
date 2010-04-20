package com.agiledoc.client.view.root;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

/**
 * Clicking at the button "Change Root and Domain", the user can change the root
 * and the domain of the classes that are being shown. <br>
 * After the click the system will start again with the new root and domain
 * selected.
 * 
 * @userTask
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class IconChangeRoot {

	/**
	 * Return the button widget that implements the Change Root functionality on
	 * the click event. After the click the system will start again with the new
	 * root and domain selected.
	 * 
	 * @author allineo
	 * @modified 04/20/2010
	 * 
	 * @link com.gwtjavadoc.client.control.ListSourceClasses
	 */
	public static Image getImage() {

		Image img = new Image("img/chart_organisation.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		img.setTitle("Change Root and Domain");

		return img;
	}
}
