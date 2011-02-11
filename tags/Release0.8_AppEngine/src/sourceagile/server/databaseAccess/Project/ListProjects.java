package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.project.Project;

/**
 * List all the projects added in the system.
 */
public class ListProjects {

	public static List<Project> list(PersistenceManager persistenceManager) {

		Query q = persistenceManager
				.newQuery(sourceagile.server.databaseAccess.entities.Project.class);
		q.setOrdering("name");

		List<sourceagile.server.databaseAccess.entities.Project> projectsDatabase = (List<sourceagile.server.databaseAccess.entities.Project>) q
				.execute();

		List<Project> projects = new ArrayList<Project>();

		for (sourceagile.server.databaseAccess.entities.Project databaseProject : projectsDatabase) {

			projects.add(ConvertDatabaseToProject.getProject(databaseProject));
		}

		return projects;
	}
}
