package sourceagile.server.classRepositories;

import java.io.File;
import java.util.HashMap;

import junit.framework.TestCase;

import org.approvaltests.Approvals;
import org.approvaltests.UseReporter;

import sourceagile.ProjectsData;
import sourceagile.server.classRepositories.subversionClassRepository.SubversionRepositoryClassImplementation;
import sourceagile.server.doclet.GetClassDoc;
import sourceagile.shared.data.UserData;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.spun.util.io.FileUtils;

@UseReporter(ViDiffReporter.class)
public class RepositoryClassLoaderTest extends TestCase {

	public void testFeaturesList() throws Exception {

		User user = UserData.load()[0];
		Project project = ProjectsData.load()[1];
		HashMap<String, ClassFile> listFeatures = new SubversionRepositoryClassImplementation()
				.listClasses(project, user);
		Approvals.approve("Entry", listFeatures.values());

	}

	public void testGetEntryFeature() throws Exception {

		ClassFile entryFeature = new ClassFile();

		File file = new File(
				"test/sourceagile/server/repositoryClassLoader/RepositoryClassLoaderTest.java");

		entryFeature.setSourceCode(FileUtils.readFile(file));

		entryFeature.setClassDoc(GetClassDoc.getClassDoc(file,
				Project.LOCALE_ENGLISH));

		Approvals.approve(ClassDocumetationUtilities.toString(entryFeature
				.getClassDoc()));
	}

}
