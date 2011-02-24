package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.shared.entities.project.ProjectComponents;

public class ConvertDatabaseToProject {

	public static Project getProject(
			sourceagile.server.databaseAccess.entities.Project databaseProject) {

		Project project = new Project();

		if (databaseProject.getProjectID() != null) {

			project.setProjectID(databaseProject.getProjectID().getId());
		}

		project.setRepositoryType(databaseProject.getRepositoryType());

		project.setName(databaseProject.getName());

		project.setDescription(databaseProject.getDescription().getValue());

		project.setProgramLanguage(databaseProject.getProgramLanguage());

		project.setProjectLocale(databaseProject.getProjectLocale());

		project.setRepositoryURL(databaseProject.getRepositoryURL());

		project.setDomain(databaseProject.getDomain());

		project.setRoot(databaseProject.getRoot());

		project.setTestRoot(databaseProject.getTestRoot());

		project.setRelatedLinks(databaseProject.getRelatedLinks().getValue());

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		List<sourceagile.server.databaseAccess.entities.ProjectComponents> projectComponentsDatabase = databaseProject
				.getProjectComponents();

		Collections.sort(projectComponentsDatabase);

		for (sourceagile.server.databaseAccess.entities.ProjectComponents projectComponentDatabase : projectComponentsDatabase) {

			projectComponents
					.add(getProjectComponent(projectComponentDatabase));
		}

		project.setProjectComponents(projectComponents);

		List<ProjectBacklog> projectBacklogs = new ArrayList<ProjectBacklog>();

		for (sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase : databaseProject
				.getProjectBacklog()) {

			projectBacklogs.add(getProjectBacklog(projectBacklogDatabase));
		}

		project.setProjectBacklog(projectBacklogs);

		return project;
	}

	private static ProjectComponents getProjectComponent(
			sourceagile.server.databaseAccess.entities.ProjectComponents projectComponentDatabase) {

		ProjectComponents projectComponent = new ProjectComponents();

		if (projectComponentDatabase.getComponentID() != null) {

			projectComponent.setComponentID(projectComponentDatabase
					.getComponentID().getId());
		}

		projectComponent.setComponentName(projectComponentDatabase
				.getComponentName());

		projectComponent.setComponentPath(projectComponentDatabase
				.getComponentPath());

		return projectComponent;
	}

	private static ProjectBacklog getProjectBacklog(
			sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase) {

		ProjectBacklog projectBacklog = new ProjectBacklog();

		if (projectBacklogDatabase.getProjectBacklogID() != null) {

			projectBacklog.setProjectBacklogID(projectBacklogDatabase
					.getProjectBacklogID().getId());
		}

		projectBacklog.setBacklogDate(new Date(projectBacklogDatabase
				.getBacklogDate().getTime()));

		projectBacklog.setBacklogName(projectBacklogDatabase.getBacklogName());

		projectBacklog.setBacklogDescription(projectBacklogDatabase
				.getBacklogDescription());

		projectBacklog.setBacklogEstimative(projectBacklogDatabase
				.getBacklogEstimative());

		projectBacklog.setBacklogPriority(projectBacklogDatabase
				.getBacklogPriority());

		projectBacklog.setBacklogStatus(projectBacklogDatabase
				.getBacklogStatus());

		return projectBacklog;
	}

}
