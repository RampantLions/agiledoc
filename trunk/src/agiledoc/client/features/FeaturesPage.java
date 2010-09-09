package agiledoc.client.features;

import agiledoc.client.navigation.LoadingPanel;
import agiledoc.client.serverConnection.ListRemoteClasses;
import agiledoc.shared.Entry;

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
		featuresTreePanel.add(new LoadingPanel());

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		add(featureVisualizationPanel);

		new ListRemoteClasses();
	}

	/**
	 * Show the tree list with all the features for the project specified.
	 */
	public static void ShowFeatureTree(Entry[] features) {

		featuresTreePanel.clear();
		featuresTreePanel.add(new FeaturesTree(features));
	}

}
