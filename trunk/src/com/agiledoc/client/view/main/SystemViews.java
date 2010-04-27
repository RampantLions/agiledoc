package com.agiledoc.client.view.main;

import com.agiledoc.client.view.help.HelpView;
import com.agiledoc.client.view.javadoc.JavadocView;
import com.agiledoc.client.view.performance.PerformanceView;
import com.agiledoc.client.view.scope.ScopeView;
import com.agiledoc.client.view.todo.ToDoView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;

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

		final ToggleButton todoButton = new ToggleButton("TO DO");
		final ToggleButton scopeButton = new ToggleButton("SCOPE");
		final ToggleButton productivityButton = new ToggleButton("PRODUCTIVITY");
		final ToggleButton helpButton = new ToggleButton("HELP");
		final ToggleButton javadocButton = new ToggleButton("JAVADOC");

		todoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(todoButton, scopeButton, productivityButton,
						helpButton, javadocButton);
				ToDoView.init();
			}
		});
		hp.add(todoButton);

		Label lb1 = new Label(" ");
		lb1.setWidth("30");
		hp.add(lb1);

		scopeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(scopeButton, todoButton, productivityButton,
						helpButton, javadocButton);

				ScopeView.init();

			}
		});
		hp.add(scopeButton);

		Label lb2 = new Label(" ");
		lb2.setWidth("30");
		hp.add(lb2);

		productivityButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(productivityButton, todoButton, scopeButton,
						helpButton, javadocButton);
				PerformanceView.init();
			}
		});
		hp.add(productivityButton);

		Label lb4 = new Label(" ");
		lb4.setWidth("30");
		hp.add(lb4);

		helpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(helpButton, todoButton, scopeButton,
						productivityButton, javadocButton);

				HelpView.init();
			}
		});
		hp.add(helpButton);

		Label lb3 = new Label(" ");
		lb3.setWidth("30");
		hp.add(lb3);

		javadocButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(javadocButton, todoButton, scopeButton, helpButton,
						productivityButton);
				JavadocView.init();
			}
		});
		hp.add(javadocButton);

		return hp;
	}

	private static void pushButtons(ToggleButton buttonDown,
			ToggleButton... buttons) {

		buttonDown.setDown(true);

		for (ToggleButton button : buttons) {

			button.setDown(false);
		}
	}

}
