package sourceagile.documentation.client.project;

import sourceagile.client.ProjectInitialization;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.documentationMenu.ProjectDescriptionLink;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class ProjectDescription extends VerticalPanel {

	public ProjectDescription() {

		Documentation.untoggleLinks();
		Documentation.projectDescriptionLink
				.setHTML(ProjectDescriptionLink.textPressed);

		this.setSpacing(40);

		HTML projectDesctiptionText = new HTML(
				ProjectInitialization.currentProject.getDescription());

		this.add(projectDesctiptionText);

		this.add(buttonEdit());

	}

	private Button buttonEdit() {

		Button button = new Button("Edit", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel
						.add(new ProjectDescriptionEdit());
			}
		});

		return button;
	}

}
