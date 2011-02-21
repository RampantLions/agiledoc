package sourceagile.client.project;

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

	public ProjectComponentForm(ProjectComponents component) {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(30);

		name.setWidth("500px");
		name.setValue(component.getComponentName());
		vp.add(new FormField("Project Name", name));

		path.setWidth("500px");
		path.setValue(component.getComponentPath());
		vp.add(new FormField("Path", path));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(buttonSaveComponent(component));

		vp.add(hp);

		this.add(vp);
	}

	private Button buttonSaveComponent(final ProjectComponents component) {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				component.setComponentName(name.getValue());
				component.setComponentPath(path.getValue());

				// new SaveProjectComponent(component);
			}
		});

		return button;
	}

}
