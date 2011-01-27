package sourceagile.server.classRepositories;

import junit.framework.TestCase;
import sourceagile.ProjectsData;
import sourceagile.server.classRepositories.subversionClassRepository.SubversionRepositoryClassImplementation;
import sourceagile.shared.data.UserData;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

public class UpdateDocumentationTest extends TestCase {
	public void testUpdate() throws Exception {

		User user = UserData.load()[0];
		Project project = ProjectsData.load()[1];
		ClassFile[] listFeatures = new SubversionRepositoryClassImplementation()
				.listClasses(project, user);
		// new DocumentationUpdater().update(listFeatures[0], "doPlay",
		// "New Documentation");

	}
}
