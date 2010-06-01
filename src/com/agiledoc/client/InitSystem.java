package com.agiledoc.client;

import com.agiledoc.client.logic.ListSourceClasses;
import com.agiledoc.client.view.main.TopPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * When the user enter the system URL, the browser shown with the first web page
 * for the system. As the first root the "Agile Documentation" system itself is
 * shown. The first view shown for a root is the Help view.
 */
public class InitSystem {

	/**
	 * Show the main structure of the system web page and List all the classes
	 * from the source code of the system root.
	 */
	public static void init() {

		RootPanel.get("mainFrame").setSize("100%", "100%");

		RootPanel.get("mainFrame").add(prepareMainPage(), 0, 0);

		new ListSourceClasses();
	}

	/**
	 * Show the main structure of the system web page, including the system
	 * navigation.
	 */
	public static VerticalPanel prepareMainPage() {

		VerticalPanel vp = new VerticalPanel();

		vp.setSize("100%", "100%");
		vp.setVerticalAlignment(VerticalPanel.ALIGN_TOP);

		vp.add(TopPanel.show());

		GlobalVariables.getVP_BODY().setSize("100%", "100%");
		GlobalVariables.getVP_BODY().setHorizontalAlignment(
				HasHorizontalAlignment.ALIGN_CENTER);
		GlobalVariables.getVP_BODY().setVerticalAlignment(
				HasVerticalAlignment.ALIGN_TOP);
		vp.add(GlobalVariables.getVP_BODY());

		return vp;
	}

}
