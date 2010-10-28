package sourceagile.server.classRepositories.subversionClassRepository.repositoryTest;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddFile;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Method;

public class CreateTestClass {

	public CreateTestClass(SVNRepository repository, ClassFile classFile,
			String newSubfolderName) throws SVNException {

		String fileName = classFile.getClassDoc().getClassName() + "Test.java";

		new AddFile(repository, classFile.getFilePath(), newSubfolderName,
				fileName, classContent(classFile, newSubfolderName));
	}

	private String classContent(ClassFile classFile, String newSubfolderName) {

		String packName = classFile.getClassDoc().getClassPackage();

		if (newSubfolderName != null && newSubfolderName.length() > 0) {

			packName = packName + "." + newSubfolderName;
		}

		String classPackage = "package " + packName + ";\n";

		String imports = "\nimport junit.framework.TestCase;\n\n";

		String classDeclaration = "public class "
				+ classFile.getClassDoc().getClassName()
				+ "Test extends TestCase {\n" + "\n";

		String classContent = classPackage + imports + classDeclaration
				+ testMethods(classFile) + "}\n";

		return classContent;
	}

	private String testMethods(ClassFile classFile) {

		Method[] methods = classFile.getClassDoc().getMethods();

		String methodsDeclarations = "";

		for (Method method : methods) {

			String nameTestMethod = "test"
					+ (method.getName().substring(0, 1)).toUpperCase()
					+ method.getName().substring(1);

			String methodDeclaration = "\tpublic void " + nameTestMethod
					+ "() { \n" + " \n\t}\n";

			methodsDeclarations += methodDeclaration;
		}

		return methodsDeclarations;
	}
}
