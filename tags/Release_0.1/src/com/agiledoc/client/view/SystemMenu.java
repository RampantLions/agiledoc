package com.agiledoc.client.view;

import com.agiledoc.client.view.features.FeaturesView;
import com.agiledoc.client.view.help.HelpView;
import com.agiledoc.client.view.javadoc.JavadocView;
import com.agiledoc.client.view.productivity.ProductivityView;
import com.agiledoc.client.view.sourceCode.SourceCodeView;
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

	public static final ToggleButton todoButton = new ToggleButton("PLANNING");
	private static final ToggleButton featuresButton = new ToggleButton(
			"FEATURES LIST");
	private static final ToggleButton helpButton = new ToggleButton(
			"HELP PAGES");
	private static final ToggleButton productivityButton = new ToggleButton(
			"METRICS");
	private static final ToggleButton javadocButton = new ToggleButton(
			"JAVADOC");
	private static final ToggleButton sourceButton = new ToggleButton(
			"SOURCE CODE");

	public SystemMenu() {

		setSpacing(5);

		add(todoButton());

		Label lb1 = new Label(" ");
		lb1.setWidth("30");
		add(lb1);

		add(featuresButton());

		Label lb5 = new Label(" ");
		lb5.setWidth("30");
		add(lb5);

		add(helpButton());

		Label lb2 = new Label(" ");
		lb2.setWidth("30");
		add(lb2);

		add(productivityButton());

		Label lb3 = new Label(" ");
		lb3.setWidth("30");
		add(lb3);

		add(javadocButton());

		Label lb4 = new Label(" ");
		lb4.setWidth("30");
		add(lb4);

		add(sourceCodeButton());

	}

	/**
	 * When the user click this button the system opens the page with a todo
	 * list.
	 */
	private static ToggleButton todoButton() {

		todoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(todoButton, featuresButton, helpButton,
						productivityButton, javadocButton, sourceButton);
				new ToDoView();
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

				pushButtons(featuresButton, todoButton, helpButton,
						productivityButton, javadocButton, sourceButton);

				new FeaturesView();

			}
		});

		return featuresButton;
	}

	/**
	 * Help Button description
	 */
	private static ToggleButton helpButton() {

		helpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(helpButton, todoButton, featuresButton,
						productivityButton, javadocButton, sourceButton);

				new HelpView();

			}
		});

		return helpButton;
	}

	/**
	 * Productivity Button description
	 */
	private static ToggleButton productivityButton() {

		productivityButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(productivityButton, todoButton, helpButton,
						featuresButton, javadocButton, sourceButton);
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
						helpButton, productivityButton, sourceButton);
				JavadocView.init();
			}
		});

		return javadocButton;
	}

	/**
	 * Source Code Button description
	 */
	private static ToggleButton sourceCodeButton() {

		sourceButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				pushButtons(sourceButton, todoButton, featuresButton,
						helpButton, productivityButton, javadocButton);
				new SourceCodeView();
			}
		});

		return sourceButton;
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
