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

	private static List<sourceagile.server.databaseAccess.entities.ProjectBacklog> getDatabaseProjectBacklog(
			List<ProjectBacklog> projectBacklogs) {

		List<sourceagile.server.databaseAccess.entities.ProjectBacklog> databaseProjectBacklogs = new ArrayList<sourceagile.server.databaseAccess.entities.ProjectBacklog>();

		for (ProjectBacklog projectBacklog : projectBacklogs) {

			sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase = new sourceagile.server.databaseAccess.entities.ProjectBacklog();

			projectBacklogDatabase.setBacklogDate(projectBacklog
					.getBacklogDate());

			projectBacklogDatabase.setBacklogName(projectBacklog
					.getBacklogName());

			projectBacklogDatabase.setBacklogDescription(projectBacklog
					.getBacklogDescription());

			projectBacklogDatabase.setBacklogEstimative(projectBacklog
					.getBacklogEstimative());

			projectBacklogDatabase.setBacklogPriority(projectBacklog
					.getBacklogPriority());

			projectBacklogDatabase.setBacklogStatus(projectBacklog
					.getBacklogStatus());

			databaseProjectBacklogs.add(projectBacklogDatabase);
		}

		return databaseProjectBacklogs;
	}

}
