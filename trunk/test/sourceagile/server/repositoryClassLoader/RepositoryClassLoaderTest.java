package sourceagile.server.repositoryClassLoader;

import java.io.File;

import junit.framework.TestCase;

import org.approvaltests.Approvals;
import org.approvaltests.UseReporter;

import sourceagile.server.doclet.GetClassDoc;
import sourceagile.shared.Entry;
import sourceagile.shared.Project;
import sourceagile.shared.User;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.data.UserData;

import com.spun.util.io.FileUtils;

@UseReporter(ViDiffReporter.class)
public class RepositoryClassLoaderTest extends TestCase {

	public void testFeaturesList() throws Exception {

		User user = UserData.load()[0];
		Project project = ProjectsData.load()[1];
		Entry[] listFeatures = new RepositoryClassLoaderImplementation()
				.ListFeatures(project, user);
		Approvals.approve("Entry", listFeatures);

	}

	public void testGetEntryFeature() throws Exception {

		Entry entryFeature = new Entry();

		File file = new File(
				"test/sourceagile/server/repositoryClassLoader/RepositoryClassLoaderTest.java");

		entryFeature.setTextContent(FileUtils.readFile(file));

		entryFeature.setClassDoc(GetClassDoc.getClassDoc(file));

		Approvals.approve(ClassDocumetationUtilities.toString(entryFeature
				.getClassDoc()));
	}

}
