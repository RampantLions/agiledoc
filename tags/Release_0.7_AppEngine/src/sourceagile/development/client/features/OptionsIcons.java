package sourceagile.development.client.features;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.HorizontalPanel;

public class OptionsIcons extends HorizontalPanel {

	public static final int OPTION_DESCRIPTION = 0;
	public static final int OPTION_TEST = 2;
	public static final int OPTION_SOURCE = 4;
	public static final int OPTION_ALLCLASSES = 5;

	public OptionsIcons(ClassFile entry) {

		setSpacing(10);

		add(new ButtonFeatureDescription(entry));

		add(new ButtonEditFeature(entry));

		add(new ButtonTest(entry));

		add(new ButtonJavadoc(entry));

		add(new ButtonSourceCode(entry));

	}

}
