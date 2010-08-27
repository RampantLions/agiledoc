package agiledoc.client.features;

import agiledoc.shared.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class FeatureOptions extends HorizontalPanel {

	public static final int optionDescription = 0;
	// public static final int optionDescription = 1;
	// public static final int optionDescription = 2;
	// public static final int optionDescription = 3;
	public static final int optionSource = 4;

	public FeatureOptions(Entry entry) {

		setSize("1200", "100%");

		setSpacing(10);

		add(ButtonFeatureDescription(entry));

		// add(IconEditDescriptions(classe));

		// add(IconTestView(classe));

		// add(IconJavadocView(classe));

		add(ButtonSourceView(entry));
	}

	private static Image ButtonFeatureDescription(final Entry entry) {

		Image img = new Image("images/list.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new FeatureDescription(entry);
			}
		});

		img.setTitle("Show Feature");

		return img;
	}

	private static Image ButtonSourceView(final Entry entry) {

		Image img = new Image("images/source.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new FeatureSource(entry);
			}
		});

		img.setTitle("View Source Code");

		return img;
	}

}
