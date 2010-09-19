package sourceagile.server.repositoryClassLoader;

import junit.framework.TestCase;
import sourceagile.shared.Entry;
import sourceagile.shared.Project;
import sourceagile.shared.User;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.data.UserData;

public class UpdateDocumentationTest extends TestCase {
	public void testUpdate() throws Exception {

		User user = UserData.load()[0];
		Project project = ProjectsData.load()[1];
		Entry[] listFeatures = new RepositoryClassLoaderImplementation()
				.ListFeatures(project, user);
		// new DocumentationUpdater().update(listFeatures[0], "doPlay",
		// "New Documentation");

	}
}
