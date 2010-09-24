package sourceagile.client.specification;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * List all the classes of the current project.
 * 
 * @feature
 */
public class Specification extends VerticalPanel {

	public VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	public Specification() {

		HorizontalPanel hp = new HorizontalPanel();

		featuresTreePanel.setSize("350px", "100%");

		hp.add(featuresTreePanel);

		featuresTreePanel.clear();

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		hp.add(featureVisualizationPanel);

		this.add(hp);
	}

}
