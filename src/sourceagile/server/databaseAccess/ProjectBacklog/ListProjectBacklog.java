package sourceagile.server.databaseAccess.ProjectBacklog;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.project.ProjectBacklog;

public class ListProjectBacklog {

	public static List<ProjectBacklog> list(
			PersistenceManager persistenceManager) {

		Query q = persistenceManager.newQuery(ProjectBacklog.class);
		// q.setOrdering("name");

		List<ProjectBacklog> projectsDatabase = (List<ProjectBacklog>) q
				.execute();

		List<ProjectBacklog> projects = new ArrayList<ProjectBacklog>();

		// for (ProjectBacklog project : projectsDatabase) {

		// projects.add(project);
		// }

		return projects;
	}
}
