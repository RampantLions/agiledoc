package sourceagile.server.databaseAccess.Project;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.shared.entities.project.Project;

public class SaveProject {

	public static void save(Project project) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		persistenceManager.makePersistent(project);

		persistenceManager.close();

	}

}
