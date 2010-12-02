package sourceagile.server.databaseAccess;

import java.util.List;

import sourceagile.server.databaseAccess.Project.GetProject;
import sourceagile.server.databaseAccess.Project.ListProjects;
import sourceagile.server.databaseAccess.Project.SaveProject;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCalls;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DatabaseAccessImplementation extends RemoteServiceServlet
		implements DatabaseAccessServerCalls {

	@Override
	public List<Project> listProjects() {

		List<Project> projects = null;

		projects = ListProjects.list();

		return projects;
	}

	@Override
	public Project getProject(Long projectID) {

		Project project = GetProject.get(projectID);

		return project;
	}

	@Override
	public void saveProject(Project project) {

		SaveProject.save(project);
	}

}
