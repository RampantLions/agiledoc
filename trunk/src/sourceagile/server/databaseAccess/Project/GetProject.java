package sourceagile.server.databaseAccess.Project;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectComponents;

/**
 * List all the projects added in the system.
 */
public class GetProject {

	public static Project get(Long projectID) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		Project projectDatabase = persistenceManager.getObjectById(
				Project.class, projectID);

		Project project = persistenceManager.detachCopy(projectDatabase);

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		for (ProjectComponents projectComponentsDatabase : project
				.getProjectComponents()) {

			ProjectComponents projectComponent = new ProjectComponents();

			projectComponent.setComponentID(projectComponentsDatabase
					.getComponentID());

			projectComponent.setComponentName(projectComponentsDatabase
					.getComponentName());

			projectComponent.setComponentPath(projectComponentsDatabase
					.getComponentPath());

			projectComponents.add(projectComponent);
		}

		project.setProjectComponents(projectComponents);

		persistenceManager.close();

		return project;
	}

}
