package sourceagile.client.features.featureOptions;

import sourceagile.shared.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class OptionsIcons extends HorizontalPanel {

	public static final int optionDescription = 0;
	public static final int optionSource = 4;

	public OptionsIcons(Entry entry) {

		setSpacing(10);

		add(ButtonFeatureDescription(entry));

		add(ButtonEditDescriptions(entry));

		add(ButtonTest(entry));

		add(ButtonJavadoc(entry));

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

		img.setTitle("Feature Description");

		return img;
	}

	private static Image ButtonEditDescriptions(final Entry entry) {

		Image img = new Image("images/edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new FeatureEdit(entry);
			}
		});

		img.setTitle("Edit");

		return img;
	}

	private static Image ButtonTest(final Entry entry) {

		Image img = new Image("images/test.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		img.setTitle("Test");

		return img;
	}

	private static Image ButtonJavadoc(final Entry entry) {

		Image img = new Image("images/javadoc.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new FeatureJavadoc(entry);
			}
		});

		img.setTitle("Javadoc");

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

		img.setTitle("Source Code");

		return img;
	}

}
