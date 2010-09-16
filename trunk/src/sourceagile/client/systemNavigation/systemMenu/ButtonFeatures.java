package sourceagile.client.systemNavigation.systemMenu;

import sourceagile.client.features.FeaturesPage;
import sourceagile.client.features.FeaturesTree;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.systemNavigation.MainPage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonFeatures extends Button {

	public ButtonFeatures() {

		setText("Features");

		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				MainPage.panelContent.clear();

				FeaturesPage featuresPage = new FeaturesPage();

				featuresPage.featuresTreePanel.add(new FeaturesTree(
						ProjectInitialization.projectEntries));

				MainPage.panelContent.add(featuresPage);
			}
		});
	}

}
