package agiledoc.client.features;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeatureVisualization extends VerticalPanel {

	public static HTML featureContent = new HTML();

	public FeatureVisualization() {

		setSize("1200", "100%");
		
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		add(new FeatureViewOptions());

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		featureContent.setSize("1200", "100%");

		add(featureContent);
	}

}
