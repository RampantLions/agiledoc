package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.client.GWTStart;
import sourceagile.client.ProjectInitialization;
import sourceagile.planning.client.PlanningPage;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * Open the Planning page for the end user.
 * 
 * TODO: Reload the project backlog list when open the page.
 * 
 * @UserManual
 * @TODO
 */
public class ButtonPlanning extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonPlanning() {

		this.setText(internationalizationConstants.planning());

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				GWTStart.mainPage.panelContent.clear();
				GWTStart.mainPage.panelContent.add(new PlanningPage(
						ProjectInitialization.projectEntries));
			}
		});
	}
}
