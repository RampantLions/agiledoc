package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectComponents;

/**
 * List all the projects added in the system.
 */
public class GetProject {

	public static Project get(PersistenceManager persistenceManager,
			Long projectID) {

		Project projectDatabase = persistenceManager.getObjectById(
				Project.class, projectID);

		Project project = persistenceManager.detachCopy(projectDatabase);

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		List<ProjectComponents> projectComponentsDatabase = project
				.getProjectComponents();

		Collections.sort(projectComponentsDatabase);

		for (ProjectComponents projectComponentDatabase : projectComponentsDatabase) {

			ProjectComponents projectComponent = new ProjectComponents();

			projectComponent.setComponentID(projectComponentDatabase
					.getComponentID());

			projectComponent.setComponentName(projectComponentDatabase
					.getComponentName());

			projectComponent.setComponentPath(projectComponentDatabase
					.getComponentPath());

			projectComponents.add(projectComponent);
		}

		project.setProjectComponents(projectComponents);

		return project;
	}

}
