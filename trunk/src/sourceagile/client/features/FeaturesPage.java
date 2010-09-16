package sourceagile.client.features;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show all the options to manipulate the Features of the current project.
 */
public class FeaturesPage extends HorizontalPanel {

	public VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	/**
	 * Show all the options to manipulate the Features of the current project
	 */
	public FeaturesPage() {

		featuresTreePanel.setSize("350px", "100%");

		add(featuresTreePanel);

		featuresTreePanel.clear();

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		add(featureVisualizationPanel);
	}
}
