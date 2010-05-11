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
 * The system offers different views for your code documentation.<br>
 * The user can switch between any of those views at any time using the menu
 * buttons at the top of the system page.
 */
public class SystemMenu extends HorizontalPanel {

	public static final ToggleButton todoButton = new ToggleButton("TO DO");
	private static final ToggleButton featuresButton = new ToggleButton(
			"FEATURES");
	private static final ToggleButton productivityButton = new ToggleButton(
			"PRODUCTIVITY");
	private static final ToggleButton javadocButton = new ToggleButton(
			"JAVADOC");

	public SystemMenu() {

		setSpacing(5);

		add(todoButton());

		Label lb1 = new Label(" ");
		lb1.setWidth("30");
		add(lb1);

		add(featuresButton());

		Label lb2 = new Label(" ");
		lb2.setWidth("30");
		add(lb2);

		add(productivityButton());

		Label lb3 = new Label(" ");
		lb3.setWidth("30");
		add(lb3);

		add(javadocButton());

	}

	/**
	 * When the user click this button the system opens the page with a todo
	 * list.
	 */
	private static ToggleButton todoButton() {

		todoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(todoButton, featuresButton, productivityButton,
						javadocButton);
				ToDoView.init();
			}
		});

		return todoButton;
	}

	/**
	 * Features Button description
	 */
	private static ToggleButton featuresButton() {

		featuresButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(featuresButton, todoButton, productivityButton,
						javadocButton);

				new FeaturesView();

			}
		});

		return featuresButton;
	}

	/**
	 * Productivity Button description
	 */
	private static ToggleButton productivityButton() {

		productivityButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(productivityButton, todoButton, featuresButton,
						javadocButton);
				ProductivityView.init();
			}
		});

		return productivityButton;
	}

	/**
	 * Javadoc Button description
	 */
	private static ToggleButton javadocButton() {

		javadocButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(javadocButton, todoButton, featuresButton,
						productivityButton);
				JavadocView.init();
			}
		});

		return javadocButton;
	}

	/**
	 * The user can click in any button at the top of the system page, so this
	 * push button will appear as clicked.
	 */
	public static void pushButtons(ToggleButton buttonDown,
			ToggleButton... buttons) {

		buttonDown.setDown(true);

		for (ToggleButton button : buttons) {

			button.setDown(false);
		}
	}

}
