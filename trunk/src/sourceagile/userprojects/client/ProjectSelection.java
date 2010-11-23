package sourceagile.userprojects.client;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Change the current project of the system.
 */
public class ProjectSelection extends VerticalPanel {

	public ProjectSelection(List<Project> projects) {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setTitle("Change Current Project");

		vp.setSpacing(10);

		vp.add(new HTML("<B>Select a Project on the list bellow: </B>"));

		vp.add(ProjectChanger.getList(projects));

		vp.add(new ProjectForm());

		this.add(vp);
	}

}
