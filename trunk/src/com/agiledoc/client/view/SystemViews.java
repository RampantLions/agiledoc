package com.agiledoc.client.view;

import com.agiledoc.client.view.features.FeaturesView;
import com.agiledoc.client.view.javadoc.JavadocView;
import com.agiledoc.client.view.productivity.ProductivityView;
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
 */
public class SystemViews {

	public static final ToggleButton todoButton = new ToggleButton("TO DO");

	/**
	 * Show a panel with the system view options to be selected by the user.
	 */
	public static HorizontalPanel getViewOptions() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(5);

		final ToggleButton scopeButton = new ToggleButton("FEATURES");
		final ToggleButton productivityButton = new ToggleButton("PRODUCTIVITY");
		final ToggleButton javadocButton = new ToggleButton("JAVADOC");

		todoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(todoButton, scopeButton, productivityButton,
						javadocButton);
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
						javadocButton);

				FeaturesView.init();

			}
		});
		hp.add(scopeButton);

		Label lb2 = new Label(" ");
		lb2.setWidth("30");
		hp.add(lb2);

		productivityButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(productivityButton, todoButton, scopeButton,
						javadocButton);
				ProductivityView.init();
			}
		});
		hp.add(productivityButton);

		Label lb3 = new Label(" ");
		lb3.setWidth("30");
		hp.add(lb3);

		javadocButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(javadocButton, todoButton, scopeButton,
						productivityButton);
				JavadocView.init();
			}
		});
		hp.add(javadocButton);

		return hp;
	}

	public static void pushButtons(ToggleButton buttonDown,
			ToggleButton... buttons) {

		buttonDown.setDown(true);

		for (ToggleButton button : buttons) {

			button.setDown(false);
		}
	}

}
