package agiledoc.client.features;

import agiledoc.shared.Entry;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeatureVisualization extends VerticalPanel {

	public static VerticalPanel featureContent = new VerticalPanel();

	public FeatureVisualization(Entry entry) {

		setSize("700px", "100%");

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		add(new FeatureOptions(entry));

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		add(featureContent);
	}

}
