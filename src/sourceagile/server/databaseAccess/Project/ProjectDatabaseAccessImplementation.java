package sourceagile.server.databaseAccess.Project;

import java.util.List;

import javax.jdo.PersistenceManager;

import sourceagile.administration.client.project.ProjectAdministrationServerCalls;
import sourceagile.authentication.client.serverCalls.AuthenticationServerCalls;
import sourceagile.client.serverCalls.ProjectDatabaseServerCalls;
import sourceagile.documentation.client.serverCalls.ProjectUpdateServerCalls;
import sourceagile.planning.client.serverCalls.GetProjectServerCalls;
import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProjectDatabaseAccessImplementation extends RemoteServiceServlet
		implements ProjectAdministrationServerCalls,
		ProjectDatabaseServerCalls, AuthenticationServerCalls,
		ProjectUpdateServerCalls, GetProjectServerCalls {

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

		SaveProject.addNew(persistenceManager, project);

		persistenceManager.close();
	}

	@Override
	public void updateProject(Project project) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProject.update(persistenceManager, project);

		persistenceManager.close();
	}

	public void deleteProject(Project project) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		DeleteProject.delete(persistenceManager, project);

		persistenceManager.close();
	}

}
