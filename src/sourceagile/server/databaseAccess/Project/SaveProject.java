package sourceagile.server.databaseAccess.Project;

import javax.jdo.PersistenceManager;

import sourceagile.shared.entities.project.Project;

public class SaveProject {

	public static void save(PersistenceManager persistenceManager,
			Project project) {

		Project projectDatabase = GetProject.get(persistenceManager,
				project.getProjectID());

		projectDatabase.setDescription(project.getDescription());

		persistenceManager.makePersistent(projectDatabase);
	}
}
