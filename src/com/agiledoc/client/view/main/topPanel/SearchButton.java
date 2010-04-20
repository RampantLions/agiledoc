package com.agiledoc.client.view.main.topPanel;




import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.ListSourceClasses;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * @todo
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class SearchButton {

	/**
	 */
	public static Button getButton(final String root, final String pack) {

		Button button = new Button("Change Root and Domain",
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						GlobalVariables.setROOT(root);
						GlobalVariables.setPACK(pack);

						new ListSourceClasses(GlobalVariables.getPACK());
					}
				});

		return button;
	}
}
