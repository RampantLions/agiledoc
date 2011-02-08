package sourceagile.server.databaseAccess.Project;

import javax.jdo.PersistenceManager;

import sourceagile.shared.entities.project.Project;

public class DeleteProject {

	public static void delete(PersistenceManager persistenceManager,
			Project project) {

		sourceagile.server.databaseAccess.entities.Project projectDatabase = GetProject
				.getProjectDatabase(persistenceManager, project.getProjectID());

		deleteProjectDatabase(persistenceManager, projectDatabase);
	}

	public static void deleteProjectDatabase(
			PersistenceManager persistenceManager,
			sourceagile.server.databaseAccess.entities.Project projectDatabase) {

		persistenceManager.deletePersistent(projectDatabase);
	}
}