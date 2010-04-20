package com.agiledoc.client.view.todo;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.ListSourceClasses;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

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
public class ButtonNewTask {

	/**
	 * Return the button widget that implements the Change Root functionality on
	 * the click event. After the click the system will start again with the new
	 * root and domain selected.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 * 
	 * @link com.gwtjavadoc.client.control.ListSourceClasses
	 */
	public static Button getButton() {

		Button button = new Button("New Task", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new ListSourceClasses(GlobalVariables.getPACK());
			}
		});

		return button;
	}
}
