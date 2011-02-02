package sourceagile.server.databaseAccess.ProjectBacklog;

import javax.jdo.PersistenceManager;

import sourceagile.planning.client.serverCalls.ProjectBacklogServerCalls;
import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @Architecture
 */
@SuppressWarnings("serial")
public class ProjectBacklogDatabaseImplementation extends RemoteServiceServlet
		implements ProjectBacklogServerCalls {

	@Override
	public void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProjectBacklog.save(persistenceManager, projectID, projectBacklog);

		persistenceManager.close();
	}
}
