package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.shared.entities.project.ProjectComponents;

public class ConvertProject {

	public static Project getProject(
			sourceagile.server.databaseAccess.entities.Project databaseProject) {

		Project project = new Project();

		project.setProjectID(databaseProject.getProjectID().getId());

		project.setRepositoryType(databaseProject.getRepositoryType());

		project.setName(databaseProject.getName());

		project.setDescription(databaseProject.getDescription());

		project.setRepositoryURL(databaseProject.getRepositoryURL());

		project.setDomain(databaseProject.getDomain());

		project.setRoot(databaseProject.getRoot());

		project.setTestRoot(databaseProject.getTestRoot());

		project.setRelatedLinks(databaseProject.getRelatedLinks());

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		for (sourceagile.server.databaseAccess.entities.ProjectComponents projectComponentDatabase : databaseProject
				.getProjectComponents()) {

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

		projectComponent.setComponentID(projectComponentDatabase
				.getComponentID().getId());

		projectComponent.setComponentName(projectComponentDatabase
				.getComponentName());

		projectComponent.setComponentPath(projectComponentDatabase
				.getComponentPath());

		return projectComponent;
	}

	private static ProjectBacklog getProjectBacklog(
			sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase) {

		ProjectBacklog projectBacklog = new ProjectBacklog();

		projectBacklog.setProjectBacklogID(projectBacklogDatabase
				.getProjectBacklogID().getId());

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

	public static sourceagile.server.databaseAccess.entities.Project getDatabaseProject(
			Project project) {

		sourceagile.server.databaseAccess.entities.Project projectDatabase = new sourceagile.server.databaseAccess.entities.Project();

		// projectDatabase.getProjectID(project.getProjectID());

		projectDatabase.setRepositoryType(project.getRepositoryType());

		projectDatabase.setName(project.getName());

		projectDatabase.setDescription(project.getDescription());

		projectDatabase.setRepositoryURL(project.getRepositoryURL());

		projectDatabase.setDomain(project.getDomain());

		projectDatabase.setRoot(project.getRoot());

		projectDatabase.setTestRoot(project.getTestRoot());

		projectDatabase.setRelatedLinks(project.getRelatedLinks());

		List<sourceagile.server.databaseAccess.entities.ProjectComponents> projectComponents = new ArrayList<sourceagile.server.databaseAccess.entities.ProjectComponents>();

		for (ProjectComponents projectComponentDatabase : project
				.getProjectComponents()) {

			projectComponents
					.add(getDatabaseProjectComponent(projectComponentDatabase));
		}

		projectDatabase.setProjectComponents(projectComponents);

		List<sourceagile.server.databaseAccess.entities.ProjectBacklog> projectBacklogs = new ArrayList<sourceagile.server.databaseAccess.entities.ProjectBacklog>();

		for (ProjectBacklog projectBacklogDatabase : project
				.getProjectBacklog()) {

			projectBacklogs
					.add(getDatabaseProjectBacklog(projectBacklogDatabase));
		}

		projectDatabase.setProjectBacklog(projectBacklogs);

		return projectDatabase;
	}

	private static sourceagile.server.databaseAccess.entities.ProjectComponents getDatabaseProjectComponent(
			ProjectComponents projectComponent) {

		sourceagile.server.databaseAccess.entities.ProjectComponents projectComponentDatabase = new sourceagile.server.databaseAccess.entities.ProjectComponents();

		// projectComponent.setComponentID(projectComponentDatabase
		// .getComponentID().getId());

		projectComponentDatabase.setComponentName(projectComponent
				.getComponentName());

		projectComponentDatabase.setComponentPath(projectComponent
				.getComponentPath());

		return projectComponentDatabase;
	}

	private static sourceagile.server.databaseAccess.entities.ProjectBacklog getDatabaseProjectBacklog(
			ProjectBacklog projectBacklog) {

		sourceagile.server.databaseAccess.entities.ProjectBacklog projectBacklogDatabase = new sourceagile.server.databaseAccess.entities.ProjectBacklog();

		// projectBacklogDatabase.setProjectBacklogID(projectBacklogDatabase
		// .getProjectBacklogID().getId());

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
