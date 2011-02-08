package sourceagile.documentation.client.project;

import sourceagile.client.ProjectInitialization;
import sourceagile.documentation.client.serverCalls.UpdateProjectDescription;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class ProjectDescriptionEdit extends VerticalPanel {

	private static RichTextArea description = new RichTextArea();

	public ProjectDescriptionEdit() {

		this.setSpacing(30);

		VerticalPanel vp = new VerticalPanel();

		description.setSize("100%", "500px");

		description.setHTML(ProjectInitialization.currentProject
				.getDescription());

		RichTextToolbar toolbar = new RichTextToolbar(description);
		toolbar.setWidth("100%");

		vp.add(toolbar);
		vp.add(description);

		this.add(vp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(buttonSaveProject());

	}

	private Button buttonSaveProject() {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProjectInitialization.currentProject.setDescription(description
						.getHTML());

				new UpdateProjectDescription(
						ProjectInitialization.currentProject);
			}
		});

		return button;
	}

}
