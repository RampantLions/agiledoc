package sourceagile.authentication.client;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.ListBox;

public class ProjectList extends ListBox {

	public ProjectList(List<Project> projects) {

		this.setWidth("200px");

		this.addItem("");

		for (Project project : projects) {

			this.addItem(project.getName(), project.getProjectID().toString());
		}
	}

	public ProjectList(boolean isDemo) {

		this.setWidth("200px");

		this.addItem("");

		this.addItem("Tic Tac Toe DEMO", "2001");
	}
}
