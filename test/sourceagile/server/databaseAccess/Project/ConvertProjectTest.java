package sourceagile.server.databaseAccess.Project;

import junit.framework.TestCase;
import sourceagile.ProjectsData;
import sourceagile.shared.entities.project.Project;

public class ConvertProjectTest extends TestCase {

	public void testGetProject() {

		// Project databaseProject;

		// Project getProjectTested =
		// ConvertProject.getProject(databaseProject);

		// assertEquals(getProjectTested, null);
	}

	public void testGetDatabaseProject() {

		Project project = ProjectsData.loadProject0();

		sourceagile.server.databaseAccess.entities.Project getDatabaseProjectTested = ConvertProject
				.getDatabaseProject(project);

		assertNotNull(getDatabaseProjectTested);

		Project getProjectTested = ConvertProject
				.getProject(getDatabaseProjectTested);

		assertNotNull(getProjectTested);
	}

}
