package sourceagile.documentation.client.projectDescription;

import sourceagile.client.ProjectInitialization;
import sourceagile.userprojects.client.serverCalls.SaveProject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * List all the features assigned for the current project.
 * 
 * @feature
 */
public class ProjectDescription extends VerticalPanel {

	private static RichTextArea description = new RichTextArea();

	public ProjectDescription() {

		this.setSpacing(30);

		VerticalPanel vp = new VerticalPanel();
		// vp.setBorderWidth(1);

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

				new SaveProject(ProjectInitialization.currentProject);
			}
		});

		return button;
	}

}
