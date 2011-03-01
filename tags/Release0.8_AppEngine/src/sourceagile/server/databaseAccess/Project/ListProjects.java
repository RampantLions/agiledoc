package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.project.Project;

/**
 * List all the projects added in the system.
 */
public class ListProjects {

	public static List<Project> list(PersistenceManager persistenceManager) {

		return list(persistenceManager, null);
	}

	public static List<Project> list(PersistenceManager persistenceManager,
			String locale) {

		Extent extent = persistenceManager.getExtent(
				sourceagile.server.databaseAccess.entities.Project.class, true);

		Query query;

		List<sourceagile.server.databaseAccess.entities.Project> projectsDatabase;

		if (locale != null) {

			String filter = "projectLocale == locale";

			if (Project.LOCALE_ENGLISH.equals(locale)) {

				filter += " || projectLocale == null";
			}

			query = persistenceManager.newQuery(extent, filter);

			query.declareParameters("String locale");

			query.setOrdering("name");

			projectsDatabase = (List<sourceagile.server.databaseAccess.entities.Project>) query
					.execute(locale);

		} else {

			query = persistenceManager.newQuery(extent);

			projectsDatabase = (List<sourceagile.server.databaseAccess.entities.Project>) query
					.execute("");
		}

		List<Project> projects = new ArrayList<Project>();

		for (sourceagile.server.databaseAccess.entities.Project databaseProject : projectsDatabase) {

			projects.add(ConvertDatabaseToProject.getProject(databaseProject));
		}

		return projects;
	}
}
