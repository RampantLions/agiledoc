package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.SystemStart;
import sourceagile.planning.client.PlanningPage;
import sourceagile.userprojects.client.ProjectInitialization;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonPlanning extends Button {

	public ButtonPlanning() {

		this.setText("Planning");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent.add(new PlanningPage(
						ProjectInitialization.projectEntries));
			}
		});
	}

}
