package com.agiledoc.client.view.main.topPanel;

import com.agiledoc.client.view.help.HelpView;
import com.agiledoc.client.view.javadoc.JavadocView;
import com.agiledoc.client.view.tasks.TasksView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * The system offers three different views for your code documentation.<br>
 * They are the Help pages for your system, the tasks definitions and the
 * javadoc generated for your source code. <br>
 * The user can switch between any of those three views.
 * 
 * @userTask
 * 
 * @author allineo
 * @modified 04/15/2010
 * 
 * @link com.gwtjavadoc.client.view.help.HelpView
 * @link com.gwtjavadoc.client.view.tasks.TasksView
 * @link com.gwtjavadoc.client.view.javadoc.JavadocView
 */
public class SystemViews {

	/**
	 * Show a panel with the system view options to be selected by the user.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 * @link com.gwtjavadoc.client.view.help.HelpView
	 * @link com.gwtjavadoc.client.view.tasks.TasksView
	 * @link com.gwtjavadoc.client.view.javadoc.JavadocView
	 */
	public static HorizontalPanel getViewOptions() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(5);
		hp.setWidth("200");

		Anchor help = new Anchor("HELP");
		help.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				HelpView.init();
			}
		});
		hp.add(help);

		Label lb1 = new Label(" ");
		lb1.setWidth("30");
		hp.add(lb1);

		Anchor tasks = new Anchor("TASKS");
		tasks.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				TasksView.init();
			}
		});
		hp.add(tasks);

		Label lb2 = new Label(" ");
		lb2.setWidth("30");
		hp.add(lb2);

		Anchor javadoc = new Anchor("JAVADOC");
		javadoc.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				JavadocView.init();
			}
		});
		hp.add(javadoc);

		return hp;
	}
}
