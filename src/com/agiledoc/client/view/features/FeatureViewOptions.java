package com.agiledoc.client.view.features;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class FeatureViewOptions extends HorizontalPanel {

	public FeatureViewOptions() {

		setSpacing(10);

		add(IconEditDescriptions());

		add(IconJavadocView());

		add(IconSourceView());
	}

	private static Image IconEditDescriptions() {

		Image img = new Image("img/script_edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// ChangeProjectPage.init();
			}
		});

		img.setTitle("Edit Descriptions");

		return img;
	}

	private static Image IconJavadocView() {

		Image img = new Image("img/javadoc.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// ChangeProjectPage.init();
			}
		});

		img.setTitle("View Javadoc");

		return img;
	}

	private static Image IconSourceView() {

		Image img = new Image("img/script_gear.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// ChangeProjectPage.init();
			}
		});

		img.setTitle("View Source Code");

		return img;
	}

}
