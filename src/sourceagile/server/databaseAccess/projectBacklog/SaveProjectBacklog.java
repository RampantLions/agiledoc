package sourceagile.server.databaseAccess.projectBacklog;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.Project.ConvertProjectToDatabase;
import sourceagile.server.databaseAccess.Project.GetProject;
import sourceagile.server.databaseAccess.entities.Project;
import sourceagile.shared.entities.project.ProjectBacklog;

public class SaveProjectBacklog {

	public static void addNew(PersistenceManager persistenceManager,
			Long projectID, ProjectBacklog projectBacklog) {

		Project projectDatabase = GetProject.getProjectDatabase(
				persistenceManager, projectID);

		projectDatabase
				.getProjectBacklog()
				.add(ConvertProjectToDatabase
						.getDatabaseProjectBacklog(
								projectBacklog,
								new sourceagile.server.databaseAccess.entities.ProjectBacklog()));

		persistenceManager.makePersistent(projectDatabase);
	}

	public static void update(PersistenceManager persistenceManager,
			ProjectBacklog projectBacklog) {

		sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase = GetProjectBacklog
				.getProjectBacklogDatabase(persistenceManager,
						projectBacklog.getProjectBacklogID());

		ConvertProjectToDatabase.getDatabaseProjectBacklog(projectBacklog,
				projectBacklogDatabase);

		persistenceManager.makePersistent(projectBacklogDatabase);
	}
}
