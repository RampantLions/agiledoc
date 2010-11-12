package sourceagile.authentication.client;

import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.ListBox;

public class ProjectList extends ListBox {

	public ProjectList() {

		this.setWidth("200px");

		this.addItem("");

		Project[] projects = ProjectsData.load();

		for (int i = 0; i < projects.length; i++) {

			Project project = projects[i];

			this.addItem(project.getName(), String.valueOf(i));
		}

	}

}
