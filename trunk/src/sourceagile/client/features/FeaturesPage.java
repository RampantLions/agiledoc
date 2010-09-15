package sourceagile.client.features;

import sourceagile.client.project.ProjectInitialization;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show all the options to manipulate the Features of the current project.
 */
public class FeaturesPage extends HorizontalPanel {

	public static VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	/**
	 * Show all the options to manipulate the Features of the current project
	 */
	public FeaturesPage() {

		featuresTreePanel.setSize("350px", "100%");

		add(featuresTreePanel);

		featuresTreePanel.clear();
		featuresTreePanel.add(new FeaturesTree(
				ProjectInitialization.projectEntries));

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		add(featureVisualizationPanel);
	}
}
