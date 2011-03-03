package sourceagile.development.client.features;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.HorizontalPanel;

public class OptionsIcons extends HorizontalPanel {

	public static final int OPTION_DESCRIPTION = 0;
	public static final int OPTION_TEST = 2;
	public static final int OPTION_REQUIREMENTS = 3;
	public static final int OPTION_SOURCE = 4;
	public static final int OPTION_ALLCLASSES = 5;

	public static ButtonFeatureDescription buttonDescription;
	public static ButtonEditFeature buttonEditFeature;
	public static ButtonTest buttonTest;
	public static ButtonJavadoc buttonJavadoc;
	public static ButtonSourceCode buttonSourceCode;

	public OptionsIcons(ClassFile entry) {

		setSpacing(10);

		buttonDescription = new ButtonFeatureDescription(entry);
		add(buttonDescription);

		buttonEditFeature = new ButtonEditFeature(entry);
		add(buttonEditFeature);

		buttonTest = new ButtonTest(entry);
		add(buttonTest);

		buttonJavadoc = new ButtonJavadoc(entry);
		add(buttonJavadoc);

		buttonSourceCode = new ButtonSourceCode(entry);
		add(buttonSourceCode);

	}

	public static void toggledButtons() {

		buttonDescription.setHTML(ButtonFeatureDescription.imageUnpressed);
		buttonEditFeature.setHTML(ButtonEditFeature.imageUnpressed);
		buttonJavadoc.setHTML(ButtonJavadoc.imageUnpressed);
		buttonTest.setHTML(ButtonTest.imageUnpressed);
		buttonSourceCode.setHTML(ButtonSourceCode.imageUnpressed);
	}

	public static void hideHints() {

		buttonDescription.descriptionHint.hide();
		buttonEditFeature.editHint.hide();
		buttonJavadoc.javadocHint.hide();
		buttonTest.testHint.hide();
		buttonSourceCode.sourceHint.hide();
	}
}
