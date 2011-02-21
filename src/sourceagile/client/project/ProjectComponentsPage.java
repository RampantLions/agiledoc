package sourceagile.client.project;

import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @Feature
 */
public class ProjectComponentsPage extends VerticalPanel {

	public ProjectComponentsPage() {

		this.setSpacing(30);
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setSize("100%", "100%");

		HTML html = new HTML(
				"<b><font color='blue' size='3'>Project Components</font></b> ");
		this.add(html);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.add(buttonNewComponent());
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ProjectComponentsList());
	}

	public Button buttonNewComponent() {

		Button buttonNewComponent = new Button();

		buttonNewComponent.setText("New Project Component");

		buttonNewComponent.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				GlobalVariables.mainPage.panelContent
						.add(new ProjectComponentForm(new ProjectComponents()));
				GlobalVariables.mainPage.panelContent
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

			}
		});

		return buttonNewComponent;
	}

}
