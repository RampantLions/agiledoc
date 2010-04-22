package com.agiledoc.client.view.main;

import com.agiledoc.client.view.help.HelpView;
import com.agiledoc.client.view.javadoc.JavadocView;
import com.agiledoc.client.view.performance.PerformanceView;
import com.agiledoc.client.view.scope.ScopeView;
import com.agiledoc.client.view.todo.ToDoView;
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
 * @link com.gwtjavadoc.client.view.help.HelpView
 * @link com.gwtjavadoc.client.view.tasks.TasksView
 * @link com.gwtjavadoc.client.view.javadoc.JavadocView
 */
public class SystemViews {

	/**
	 * Show a panel with the system view options to be selected by the user.
	 * 
	 * @link com.gwtjavadoc.client.view.help.HelpView
	 * @link com.gwtjavadoc.client.view.tasks.TasksView
	 * @link com.gwtjavadoc.client.view.javadoc.JavadocView
	 */
	public static HorizontalPanel getViewOptions() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(5);

		Anchor todo = new Anchor("TO DO");
		todo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				ToDoView.init();
			}
		});
		hp.add(todo);

		Label lb1 = new Label(" ");
		lb1.setWidth("30");
		hp.add(lb1);

		Anchor scope = new Anchor("SCOPE");
		scope.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				ScopeView.init();
			}
		});
		hp.add(scope);

		Label lb2 = new Label(" ");
		lb2.setWidth("30");
		hp.add(lb2);

		Anchor measure = new Anchor("PERFORMANCE");
		measure.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				PerformanceView.init();
			}
		});
		hp.add(measure);

		Label lb4 = new Label(" ");
		lb4.setWidth("30");
		hp.add(lb4);

		Anchor help = new Anchor("HELP");
		help.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				HelpView.init();
			}
		});
		hp.add(help);

		Label lb3 = new Label(" ");
		lb3.setWidth("30");
		hp.add(lb3);

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
