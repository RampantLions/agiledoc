package sourceagile.planning.client.projectBacklog;

import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * 
 * @UserManual
 */
public class ButtonNewStory extends Button {

	public ButtonNewStory() {

		this.setText("New Story");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new StoryForm(
						new ProjectBacklog()));

			}
		});
	}
}
