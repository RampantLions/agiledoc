package sourceagile.server.classRepositories.subversionClassRepository.repositoryTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.GetRepositoryClass;
import sourceagile.shared.ClassFile;

public class GetRepositoryTestClass {

	public static ClassFile getTestClassFile(SVNRepository repository,
			ClassFile entry) throws SVNException, IOException {

		ClassFile entryTest = new ClassFile();

		entryTest.setFilePath(entry.getFilePath());

		entryTest.setFileName(entry.getClassDoc().getClassName() + "Test.java");

		String classPath = entryTest.getFilePath() + "/"
				+ entryTest.getFileName();

		ByteArrayOutputStream baos = GetRepositoryClass.getRemoteClass(
				repository, classPath);

		entryTest.setSourceCode(baos.toString());

		GetRepositoryClass.loadClassDocumentation(baos, entryTest);

		return entryTest;
	}

}
