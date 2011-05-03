package sourceagile.server.classRepositories.subversionClassRepository.repositoryTest;

import sourceagile.server.classRepositories.subversionClassRepository.GetClass;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

public class GetRepositoryTestClass {

	public static ClassFile getTestClassFile(Project project, User user,
			ClassFile entry) {

		ClassFile entryTest = new ClassFile();

		String className = entry.getClassDoc().getClassName() + "Test.java";

		entryTest.setFileName(className);

		entryTest.setFilePath(entry.getFilePath());

		String classPath = entryTest.getFileName();

		if (!(entryTest.getFilePath() == null || entryTest.getFilePath()
				.length() == 0)) {

			classPath = entryTest.getFilePath() + "/" + entryTest.getFileName();
		}

		GetClass.getClass(project, user, entryTest);

		return entryTest;
	}

}
