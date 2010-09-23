package sourceagile.client.systemNavigation.systemMenu;

import sourceagile.client.SystemStart;
import sourceagile.client.features.FeaturesList;
import sourceagile.client.project.ProjectInitialization;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonFeatures extends Button {

	public ButtonFeatures() {

		this.setText("Features");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent.add(new FeaturesList(
						ProjectInitialization.projectEntries));
			}
		});
	}

}
