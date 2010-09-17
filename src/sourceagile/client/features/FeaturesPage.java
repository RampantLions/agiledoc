package sourceagile.client.features;

import sourceagile.client.SystemInitialization;
import sourceagile.client.project.ProjectInitialization;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show all the options to manipulate the Features of the current project.
 */
public class FeaturesPage extends VerticalPanel {

	public VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	/**
	 * Show all the options to manipulate the Features of the current project
	 */
	public FeaturesPage() {

		HorizontalPanel hp1 = new HorizontalPanel();

		Label space = new Label(" ");
		space.setWidth("200px");
		hp1.add(space);
		hp1.add(ButtonFeaturesReport());

		this.add(hp1);

		HorizontalPanel hp = new HorizontalPanel();

		featuresTreePanel.setSize("350px", "100%");

		hp.add(featuresTreePanel);

		featuresTreePanel.clear();

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		hp.add(featureVisualizationPanel);

		this.add(hp);
	}

	private static Image ButtonFeaturesReport() {

		Image img = new Image("images/report.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SystemInitialization.mainPage.panelContent.clear();
				SystemInitialization.mainPage.panelContent
						.add(new FeaturesList(
								ProjectInitialization.projectEntries));
			}
		});

		img.setTitle("Features List");

		return img;
	}
}
