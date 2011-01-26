package sourceagile.server.databaseAccess.Project;

import javax.jdo.PersistenceManager;

import sourceagile.shared.entities.project.Project;

public class SaveProject {

	public static void addNew(PersistenceManager persistenceManager,
			Project project) {

		persistenceManager.makePersistent(ConvertProject
				.getDatabaseProject(project));
	}

	public static void update(PersistenceManager persistenceManager,
			Project project) {

	}

}