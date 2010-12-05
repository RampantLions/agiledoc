package sourceagile.server.databaseAccess;

import java.util.List;

import javax.jdo.PersistenceManager;

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

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		List<Project> projects = null;

		projects = ListProjects.list(persistenceManager);

		persistenceManager.close();

		return projects;
	}

	@Override
	public Project getProject(Long projectID) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		Project project = GetProject.get(persistenceManager, projectID);

		persistenceManager.close();

		return project;
	}

	@Override
	public void saveProject(Project project) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProject.save(persistenceManager, project);

		persistenceManager.close();
	}

}
