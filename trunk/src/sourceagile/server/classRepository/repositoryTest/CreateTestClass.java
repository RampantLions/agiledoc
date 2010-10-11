package sourceagile.server.classRepository.repositoryTest;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.classRepository.repositoryEditor.AddFile;
import sourceagile.shared.ClassFile;

public class CreateTestClass {

	public CreateTestClass(SVNRepository repository, ClassFile classFile)
			throws SVNException {

		String fileName = classFile.getClassDoc().getClassName() + "Test.java";

		new AddFile(repository, classFile.getFilePath(),
				classFile.getFilePath(), fileName, classContent(classFile));
	}

	private String classContent(ClassFile classFile) {

		String classPackage = "package "
				+ classFile.getClassDoc().getClassPackage() + ";\n";

		String imports = "\nimport junit.framework.TestCase;\n\n";

		String classDeclaration = "public class "
				+ classFile.getClassDoc().getClassName()
				+ "Test extends TestCase {\n" + "\n" + "}\n";

		String classContent = classPackage + imports + classDeclaration;

		return classContent;
	}
}
