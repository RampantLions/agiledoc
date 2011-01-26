package sourceagile.server.databaseAccess.Project;

import javax.jdo.PersistenceManager;

import sourceagile.server.databaseAccess.entities.Project;

public class GetProject {

	public static sourceagile.shared.entities.project.Project get(
			PersistenceManager persistenceManager, Long projectID) {

		Project projectDatabase = persistenceManager.getObjectById(
				Project.class, projectID);

		sourceagile.shared.entities.project.Project project = ConvertProject
				.getProject(projectDatabase);

		return project;
	}

}
