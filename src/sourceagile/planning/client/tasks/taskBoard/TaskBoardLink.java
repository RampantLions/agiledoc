package sourceagile.planning.client.tasks.taskBoard;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.ProjectInitialization;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class TaskBoardLink extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String textUnpressed = "<font color='orange'><b><a href='#'>"
			+ internationalizationConstants.taskBoard() + "</a></b></font>";

	public TaskBoardLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new TaskBoard(
						ProjectInitialization.projectEntries));
			}
		});

	}
}
