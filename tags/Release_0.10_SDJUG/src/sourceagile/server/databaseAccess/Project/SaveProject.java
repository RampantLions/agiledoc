package sourceagile.server.databaseAccess.Project;

import javax.jdo.PersistenceManager;

import sourceagile.shared.entities.project.Project;

public class SaveProject {

	public static void addNew(PersistenceManager persistenceManager,
			Project project) {

		sourceagile.server.databaseAccess.entities.Project projectDatabase = ConvertProjectToDatabase
				.getDatabaseProject(
						new sourceagile.server.databaseAccess.entities.Project(),
						project);

		projectDatabase.setProjectComponents(ConvertProjectToDatabase
				.getDatabaseProjectComponent(project.getProjectComponents()));

		projectDatabase.setProjectBacklog(ConvertProjectToDatabase
				.getDatabaseProjectBacklogs(project.getProjectBacklog()));

		persistenceManager.makePersistent(projectDatabase);
	}

	public static void update(PersistenceManager persistenceManager,
			Project project) {

		sourceagile.server.databaseAccess.entities.Project projectDatabase = GetProject
				.getProjectDatabase(persistenceManager, project.getProjectID());

		persistenceManager.makePersistent(ConvertProjectToDatabase
				.getDatabaseProject(projectDatabase, project));
	}
}