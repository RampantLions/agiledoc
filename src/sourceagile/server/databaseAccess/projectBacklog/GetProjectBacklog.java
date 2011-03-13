package sourceagile.server.databaseAccess.projectBacklog;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.entities.ProjectBacklog;

public class GetProjectBacklog {

	public static ProjectBacklog getProjectBacklogDatabase(
			PersistenceManager persistenceManager, Long projectBacklogID) {

		ProjectBacklog projectBacklogDatabase = persistenceManager
				.getObjectById(ProjectBacklog.class, projectBacklogID);

		return projectBacklogDatabase;
	}
}
