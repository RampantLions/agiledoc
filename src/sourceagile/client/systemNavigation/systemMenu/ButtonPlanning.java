package sourceagile.client.systemNavigation.systemMenu;

import sourceagile.client.planning.TodoPage;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.systemNavigation.MainPage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonPlanning extends Button {

	public ButtonPlanning() {

		setText("Planning");

		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				MainPage.panelContent.clear();
				MainPage.panelContent.add(new TodoPage(
						ProjectInitialization.projectEntries));
			}
		});
	}

}
