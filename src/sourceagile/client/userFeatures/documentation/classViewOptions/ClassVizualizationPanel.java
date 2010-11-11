package sourceagile.client.userFeatures.documentation.classViewOptions;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ClassVizualizationPanel extends VerticalPanel {

	public static VerticalPanel featureContent = new VerticalPanel();

	public ClassVizualizationPanel(ClassFile entry) {

		setSize("700px", "100%");

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		add(new OptionsIcons(entry));

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		add(featureContent);
	}

}
