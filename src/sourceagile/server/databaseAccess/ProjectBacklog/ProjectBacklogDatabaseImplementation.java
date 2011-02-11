package sourceagile.server.databaseAccess.projectBacklog;

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
	public void addProjectBacklog(Long projectID, ProjectBacklog projectBacklog) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProjectBacklog
				.addNew(persistenceManager, projectID, projectBacklog);

		persistenceManager.close();
	}

	@Override
	public void updateProjectBacklog(Long projectID,
			ProjectBacklog projectBacklog) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveProjectBacklog.update(persistenceManager, projectBacklog);

		persistenceManager.close();
	}
}
