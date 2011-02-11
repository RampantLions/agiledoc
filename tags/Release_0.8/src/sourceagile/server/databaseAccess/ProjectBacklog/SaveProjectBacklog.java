package sourceagile.server.databaseAccess.ProjectBacklog;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.Project.GetProject;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;

public class SaveProjectBacklog {

	public static void save(PersistenceManager persistenceManager,
			Long projectID, ProjectBacklog projectBacklog) {

		Project projectDatabase = GetProject.get(persistenceManager, projectID);

		projectDatabase.getProjectBacklog().add(projectBacklog);

		persistenceManager.makePersistent(projectDatabase);
	}
}
