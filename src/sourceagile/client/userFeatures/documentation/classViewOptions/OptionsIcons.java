package sourceagile.client.userFeatures.documentation.classViewOptions;

import sourceagile.client.serverCalls.test.GetRemoteTestClass;
import sourceagile.client.userFeatures.documentation.features.FeatureDescription;
import sourceagile.client.userFeatures.documentation.features.FeatureEdit;
import sourceagile.client.userFeatures.source.JavadocView;
import sourceagile.client.userFeatures.source.SourceCodeView;
import sourceagile.shared.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class OptionsIcons extends HorizontalPanel {

	public static final int OPTION_DESCRIPTION = 0;
	public static final int OPTION_TEST = 2;
	public static final int OPTION_SOURCE = 4;

	public OptionsIcons(ClassFile entry) {

		setSpacing(10);

		add(ButtonFeatureDescription(entry));

		add(ButtonEditDescriptions(entry));

		add(ButtonTest(entry));

		add(ButtonJavadoc(entry));

		add(ButtonSourceView(entry));

	}

	private static Image ButtonFeatureDescription(final ClassFile entry) {

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

	private static Image ButtonEditDescriptions(final ClassFile entry) {

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

	private static Image ButtonTest(final ClassFile entry) {

		Image img = new Image("images/test.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new GetRemoteTestClass(entry, OPTION_TEST);
			}
		});

		img.setTitle("Test");

		return img;
	}

	private static Image ButtonJavadoc(final ClassFile entry) {

		Image img = new Image("images/javadoc.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new JavadocView(entry);
			}
		});

		img.setTitle("Javadoc");

		return img;
	}

	private static Image ButtonSourceView(final ClassFile entry) {

		Image img = new Image("images/source.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new SourceCodeView(entry);
			}
		});

		img.setTitle("Source Code");

		return img;
	}

}
