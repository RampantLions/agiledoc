package sourceagile.client.authentication;

import sourceagile.shared.Project;
import sourceagile.shared.data.ProjectsData;

import com.google.gwt.user.client.ui.ListBox;

public class ProjectList extends ListBox {

	public ProjectList() {

		this.setWidth("200px");

		this.addItem("");

		for (Project proj : ProjectsData.load()) {

			this.addItem(proj.getName());
		}

	}

}
