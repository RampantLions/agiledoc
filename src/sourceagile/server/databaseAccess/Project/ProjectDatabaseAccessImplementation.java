package sourceagile.server.databaseAccess.Project;

import java.util.List;

import javax.jdo.PersistenceManager;

import sourceagile.authentication.client.serverCalls.AuthenticationServerCalls;
import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.server.databaseAccess.ProjectBacklog.SaveProjectBacklog;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.userprojects.client.serverCalls.ProjectDatabaseServerCalls;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @architecture
 */
@SuppressWarnings("serial")
public class ProjectDatabaseAccessImplementation extends RemoteServiceServlet
		implements ProjectDatabaseServerCalls, AuthenticationServerCalls {

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

	@Override
	public void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProjectBacklog.save(persistenceManager, projectID, projectBacklog);

		persistenceManager.close();
	}
}
