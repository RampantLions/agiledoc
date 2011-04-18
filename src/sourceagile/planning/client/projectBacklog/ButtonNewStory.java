package sourceagile.planning.client.projectBacklog;

import helpagile.client.exportation.HelpHint;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * 
 * @UserManual
 */
public class ButtonNewStory extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String imageUnpressed = "<a href='#'><img src='images/add.gif'></a>";

	public PopupPanel addStoryHint;

	public ButtonNewStory() {

		this.setHTML(imageUnpressed);

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new AddNewStory(
						new ProjectBacklog()));

			}
		});

		addStoryHint = HelpHint.getHelpHintLinked(this.getClass().getName(),
				internationalizationConstants.addNewTask(),
				GlobalVariables.locale);

		this.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				OptionsIcons.hideHints();

				HelpHint.executeMouseOverHandler(event, addStoryHint, null);

			}
		});
	}
}
