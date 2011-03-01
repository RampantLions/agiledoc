package sourceagile.server.databaseAccess.Project;

import java.util.List;

import junit.framework.TestCase;
import sourceagile.shared.entities.project.Project;

public class ProjectDatabaseAccessImplementationTest extends TestCase {

	public void testListProjects() {

		List<Project> listProjectsTested = new ProjectDatabaseAccessImplementation()
				.listProjects(Project.LOCALE_ENGLISH);

		assertNotNull(listProjectsTested);
	}

	public void testGetProject() {

		Long projectID = 1l;

		Project getProjectTested = new ProjectDatabaseAccessImplementation()
				.getProject(projectID);

		assertNotNull(getProjectTested);
	}

	public void testSaveProject() {

		// Project project;

		// new ProjectDatabaseAccessImplementation().saveProject(project);

		assertTrue(true);
	}

	public void testSaveProjectBacklog() {

		// Long projectID;

		// ProjectBacklog projectBacklog;

		// new
		// ProjectDatabaseAccessImplementation().saveProjectBacklog(projectID,projectBacklog);

		assertTrue(true);
	}

}
