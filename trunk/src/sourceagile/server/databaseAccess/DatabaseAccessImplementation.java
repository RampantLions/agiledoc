package sourceagile.server.databaseAccess;

import java.util.List;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.Comments.ListClassComments;
import sourceagile.server.databaseAccess.Comments.SaveComment;
import sourceagile.server.databaseAccess.Project.GetProject;
import sourceagile.server.databaseAccess.Project.ListProjects;
import sourceagile.server.databaseAccess.Project.SaveProject;
import sourceagile.server.databaseAccess.ProjectBacklog.SaveProjectBacklog;
import sourceagile.shared.entities.Comments;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCalls;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * 
 * @architecture
 */

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

	@Override
	public void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProjectBacklog.save(persistenceManager, projectID, projectBacklog);

		persistenceManager.close();
	}

	@Override
	public List<Comments> listComments(Long projectID, String classPath) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		List<Comments> comments = ListClassComments.list(persistenceManager,
				projectID, classPath);

		persistenceManager.close();

		return comments;
	}

	@Override
	public void saveComment(Comments comment) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveComment.save(persistenceManager, comment);

		persistenceManager.close();
	}
}
