package com.agiledoc.client.view.todo;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/20/2010
 */
public class ToDoView {

	/**
	 * @author allineo
	 * @modified 04/20/2010
	 */
	public static void init() {

		GlobalVariables.getVP_BODY().clear();

		GlobalVariables.setVP_BODY(preparePage());
	}

	/**
	 * 
	 * @author allineo
	 * @modified 04/20/2010
	 */
	public static VerticalPanel preparePage() {

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp1.add(ButtonNewTask.getButton());

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.add(ToDoList.showGrid());

		vp.add(vp1);
		return vp;
	}
}
