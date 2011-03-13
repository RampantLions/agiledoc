package sourceagile.client.project;

import sourceagile.client.ProjectInitialization;
import sourceagile.client.serverCalls.UpdateProject;
import sourceagile.shared.entities.project.ProjectComponents;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class ProjectComponentForm extends VerticalPanel {

	public static final TextBox name = new TextBox();
	public static final TextBox path = new TextBox();

	public ProjectComponentForm(Integer componentIndex) {

		ProjectComponents component;

		if (componentIndex != null) {

			component = ProjectInitialization.currentProject
					.getProjectComponents().get(componentIndex);
		} else {

			component = new ProjectComponents();
		}

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(30);

		name.setWidth("500px");
		name.setValue(component.getComponentName());
		vp.add(new FormField("Component Name", name));

		path.setWidth("500px");
		path.setValue(component.getComponentPath());
		vp.add(new FormField("Component Path", path));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(buttonSaveComponent(componentIndex));

		vp.add(hp);

		this.add(vp);
	}

	private Button buttonSaveComponent(final Integer componentIndex) {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Integer index = componentIndex;

				if (componentIndex == null) {

					index = ProjectInitialization.currentProject
							.getProjectComponents().size();
					ProjectInitialization.currentProject.getProjectComponents()
							.add(new ProjectComponents());
				}

				ProjectInitialization.currentProject.getProjectComponents()
						.get(index).setComponentName(name.getValue());

				ProjectInitialization.currentProject.getProjectComponents()
						.get(index).setComponentPath(path.getValue());

				new UpdateProject(ProjectInitialization.currentProject);
			}
		});

		return button;
	}

}
