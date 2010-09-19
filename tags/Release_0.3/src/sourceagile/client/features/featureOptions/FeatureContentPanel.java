package sourceagile.client.features.featureOptions;

import sourceagile.shared.Entry;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeatureContentPanel extends VerticalPanel {

	public static VerticalPanel featureContent = new VerticalPanel();

	public FeatureContentPanel(Entry entry) {

		setSize("700px", "100%");

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		add(new OptionsIcons(entry));

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		add(featureContent);
	}

}
