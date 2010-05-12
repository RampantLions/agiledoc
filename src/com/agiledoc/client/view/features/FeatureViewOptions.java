package com.agiledoc.client.view.features;

import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class FeatureViewOptions extends HorizontalPanel {

	public FeatureViewOptions(Classe classe) {

		setSpacing(10);

		add(IconEditDescriptions(classe));

		add(IconJavadocView(classe));

		add(IconSourceView(classe));
	}

	private static Image IconEditDescriptions(final Classe classe) {

		Image img = new Image("img/script_edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new EditFeatureDescription(classe);
			}
		});

		img.setTitle("Edit Descriptions");

		return img;
	}

	private static Image IconJavadocView(final Classe classe) {

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

	private static Image IconSourceView(final Classe classe) {

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
