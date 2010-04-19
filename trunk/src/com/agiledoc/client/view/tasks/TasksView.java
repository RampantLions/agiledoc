package com.agiledoc.client.view.tasks;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/193/2010
 */
public class TasksView {

	/**
	 * @author allineo
	 * @modified 04/19/2010
	 */
	public static void init() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.setVP_BODY(preparePage());
	}

	/**
	 * 
	 * @author allineo
	 * @modified 04/19/2010
	 */
	public static TabPanel preparePage() {

		TabPanel tabPanel = new TabPanel();
		tabPanel.setSize("100%", "100%");

		tabPanel.add(ToDoList.showGrid(), "To Do List");

		tabPanel.add(ToDoList.showGrid(), "Scope");

		tabPanel.add(ToDoList.showGrid(), "Measurements");

		tabPanel.selectTab(0);
		return tabPanel;

	}

}
