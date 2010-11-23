package sourceagile.userprojects.client;

import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.serverCalls.GetProject;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

public class ProjectChanger {

	public static ProjectList getList(List<Project> projects) {

		final ProjectList projectList = new ProjectList(projects);

		projectList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				if (projectList.getSelectedIndex() > 0) {

					Long projectSelected = new Long(projectList
							.getValue(projectList.getSelectedIndex()));

					new GetProject(projectSelected);
				}
			}
		});

		return projectList;
	}
}
