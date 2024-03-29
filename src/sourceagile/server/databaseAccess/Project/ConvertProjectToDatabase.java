package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.shared.entities.project.ProjectComponents;

public class ConvertProjectToDatabase {

	public static sourceagile.server.databaseAccess.entities.Project getDatabaseProject(
			sourceagile.server.databaseAccess.entities.Project projectDatabase,
			Project project) {

		projectDatabase.setRepositoryType(project.getRepositoryType());

		projectDatabase.setName(project.getName());

		projectDatabase.setDescription(project.getDescription());

		projectDatabase.setProgramLanguage(project.getProgramLanguage());

		projectDatabase.setProjectLocale(project.getProjectLocale());

		projectDatabase.setRepositoryURL(project.getRepositoryURL());

		projectDatabase.setDomain(project.getDomain());

		projectDatabase.setRoot(project.getRoot());

		projectDatabase.setTestRoot(project.getTestRoot());

		projectDatabase.setRelatedLinks(project.getRelatedLinks());

		return projectDatabase;
	}

	public static List<sourceagile.server.databaseAccess.entities.ProjectComponents> getDatabaseProjectComponent(
			List<ProjectComponents> projectComponents) {

		List<sourceagile.server.databaseAccess.entities.ProjectComponents> databaseProjectComponents = new ArrayList<sourceagile.server.databaseAccess.entities.ProjectComponents>();

		for (ProjectComponents projectComponent : projectComponents) {

			sourceagile.server.databaseAccess.entities.ProjectComponents projectComponentDatabase = new sourceagile.server.databaseAccess.entities.ProjectComponents();

			projectComponentDatabase.setComponentName(projectComponent
					.getComponentName());

			projectComponentDatabase.setComponentPath(projectComponent
					.getComponentPath());

			databaseProjectComponents.add(projectComponentDatabase);
		}

		return databaseProjectComponents;
	}

	public static List<sourceagile.server.databaseAccess.entities.ProjectBacklog> getDatabaseProjectBacklogs(
			List<ProjectBacklog> projectBacklogs) {

		List<sourceagile.server.databaseAccess.entities.ProjectBacklog> databaseProjectBacklogs = new ArrayList<sourceagile.server.databaseAccess.entities.ProjectBacklog>();

		for (ProjectBacklog projectBacklog : projectBacklogs) {

			sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase = new sourceagile.server.databaseAccess.entities.ProjectBacklog();

			databaseProjectBacklogs.add(getDatabaseProjectBacklog(
					projectBacklog, projectBacklogDatabase));
		}

		return databaseProjectBacklogs;
	}

	public static sourceagile.server.databaseAccess.entities.ProjectBacklog getDatabaseProjectBacklog(
			ProjectBacklog projectBacklog,
			sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase) {

		projectBacklogDatabase.setBacklogDate(projectBacklog.getBacklogDate());

		projectBacklogDatabase.setBacklogName(projectBacklog.getBacklogName());

		projectBacklogDatabase.setBacklogDescription(projectBacklog
				.getBacklogDescription());

		projectBacklogDatabase.setBacklogEstimative(projectBacklog
				.getBacklogEstimative());

		projectBacklogDatabase.setBacklogPriority(projectBacklog
				.getBacklogPriority());

		projectBacklogDatabase.setBacklogStatus(projectBacklog
				.getBacklogStatus());

		return projectBacklogDatabase;
	}
}
