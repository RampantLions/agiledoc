package agiledoc.client.features;

import java.util.List;

import agiledoc.client.navigation.LoadingPanel;
import agiledoc.client.serverConnection.ListRemoteClasses;
import agiledoc.shared.Entry;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturesPage extends HorizontalPanel {

	public static VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	/*
	 *  test
	 */
	public FeaturesPage() {

		featuresTreePanel.setSize("400", "100%");

		add(featuresTreePanel);

		featuresTreePanel.clear();
		featuresTreePanel.add(new LoadingPanel());

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSize("1200", "100%");
		featureVisualizationPanel.setSpacing(30);
		add(featureVisualizationPanel);

		new ListRemoteClasses();
	}

	public static void ShowFeatureTree(List<Entry> features) {

		featuresTreePanel.clear();
		featuresTreePanel.add(new FeaturesTree(features));
	}

}
