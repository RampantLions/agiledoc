package agiledoc.client.features;

import java.util.List;

import agiledoc.client.navigation.LoadingPanel;
import agiledoc.client.serverConnection.ListRemoteClasses;
import agiledoc.shared.Entry;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturesPage extends HorizontalPanel {

	public static VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureContent = new VerticalPanel();

	public FeaturesPage() {

		add(featuresTreePanel);
		add(featureContent);

		featuresTreePanel.clear();
		featuresTreePanel.add(new LoadingPanel());

		new ListRemoteClasses();
	}

	public static void ShowFeatureTree(List<Entry> features) {

		featuresTreePanel.clear();
		featuresTreePanel.add(new FeaturesTree(features));
	}

}
