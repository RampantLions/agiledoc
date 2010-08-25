package agiledoc.client.features;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class FeatureViewOptions extends HorizontalPanel {

	public FeatureViewOptions() {

		setSize("1200", "100%");

		setSpacing(10);

		add(ButtonFeatureDescription());

		// add(IconEditDescriptions(classe));

		// add(IconTestView(classe));

		// add(IconJavadocView(classe));

		add(ButtonSourceView());
	}

	private static Image ButtonFeatureDescription() {

		Image img = new Image("images/list.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		img.setTitle("Show Feature");

		return img;
	}

	private static Image ButtonSourceView() {

		Image img = new Image("images/source.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		img.setTitle("View Source Code");

		return img;
	}

}
