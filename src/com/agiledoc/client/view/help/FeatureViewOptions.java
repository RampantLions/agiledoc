package com.agiledoc.client.view.help;

import com.agiledoc.client.control.GetSourceCode;
import com.agiledoc.client.view.javadoc.JavadocClassPage;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class FeatureViewOptions extends HorizontalPanel {

	public FeatureViewOptions(Classe classe) {

		setSpacing(10);

		add(IconShowFeature(classe));

		add(IconEditDescriptions(classe));

		add(IconTestView(classe));

		add(IconJavadocView(classe));

		add(IconSourceView(classe));
	}

	private static Image IconShowFeature(final Classe classe) {

		Image img = new Image("img/list.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				HelpView.showFeature(
						new FeaturePage(FeaturesList.initialClass),
						FeaturesList.initialClass);
			}
		});

		img.setTitle("Show Feature");

		return img;
	}

	private static Image IconEditDescriptions(final Classe classe) {

		Image img = new Image("img/script_edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				HelpView
						.showFeature(new EditFeatureDescription(classe), classe);
			}
		});

		img.setTitle("Edit Descriptions");

		return img;
	}

	private static Image IconTestView(final Classe classe) {

		Image img = new Image("img/unitTest.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// FeaturesView.showFeature(new
				// JavadocClassPage(classe),classe);
			}
		});

		img.setTitle("Unit Test");

		return img;
	}

	private static Image IconJavadocView(final Classe classe) {

		Image img = new Image("img/javadoc.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				HelpView.showFeature(new JavadocClassPage(classe), classe);
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

				new GetSourceCode(classe, HelpView.vpBody);
			}
		});

		img.setTitle("View Source Code");

		return img;
	}

}
