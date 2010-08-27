package agiledoc.client.features;

import java.util.List;

import agiledoc.client.navigation.LoadingPanel;
import agiledoc.client.serverConnection.ListRemoteClasses;
import agiledoc.shared.Entry;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/*
 * Show all the options to manipulate the Features of the current project
 */
public class FeaturesPage extends HorizontalPanel {

	public static VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	public FeaturesPage() {

		featuresTreePanel.setSize("400", "100%");

		add(featuresTreePanel);

		featuresTreePanel.clear();
		featuresTreePanel.add(new LoadingPanel());

		HTML space = new HTML(
				" &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ");
		space.setHeight("40");
		add(space);

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSize("1200", "100%");
		featureVisualizationPanel.setSpacing(20);
		add(featureVisualizationPanel);

		new ListRemoteClasses();
	}

	public static void ShowFeatureTree(List<Entry> features) {

		featuresTreePanel.clear();
		featuresTreePanel.add(new FeaturesTree(features));
	}

}
