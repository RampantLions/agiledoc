package sourceagile.server.classRepositories.subversionClassRepository.repositoryTest;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddFile;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddTodoClass;
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

		String classPackage = AddTodoClass.PACKAGE + " " + packName + ";\n";

		String imports = "\nimport junit.framework.TestCase;";
		imports += "\nimport " + classFile.getClassDoc().getClassPackage()
				+ "." + classFile.getClassDoc().getClassName() + ";\n\n";

		String classDeclaration = AddTodoClass.PUBLIC + " "
				+ AddTodoClass.CLASS + " "
				+ classFile.getClassDoc().getClassName() + "Test "
				+ AddTodoClass.EXTENDS + " TestCase {\n" + "\n";

		String classContent = classPackage + imports + classDeclaration
				+ testMethods(classFile) + "}\n";

		return classContent;
	}

	private String testMethods(ClassFile classFile) {

		Method[] methods = classFile.getClassDoc().getMethods();

		String methodsDeclarations = "";

		for (Method method : methods) {

			if (method.getModifiers().contains(AddTodoClass.PUBLIC)) {

				String nameTestMethod = "test"
						+ (method.getName().substring(0, 1)).toUpperCase()
						+ method.getName().substring(1);

				String methodDeclaration = "\t" + AddTodoClass.PUBLIC + " "
						+ AddTodoClass.VOID + " " + nameTestMethod + "() { \n"
						+ getClassDeclaration(classFile, method);

				String assertCommand = "\n\n\t\t" + "assertTrue(true)" + ";";

				methodsDeclarations += methodDeclaration + assertCommand
						+ "\n\t}\n\n";
			}
		}

		return methodsDeclarations;
	}

	private String getClassDeclaration(ClassFile classFile, Method method) {

		String parametersDeclaration = "";

		String parametersComments = "";

		if (method.getParameters() != null
				&& method.getParameters().length() > 0) {

			String[] splitedParameters = method.getParameters().split(" ");

			for (int i = 0; i < splitedParameters.length; i += 2) {

				String parameterType = splitedParameters[i];
				String parameterName = splitedParameters[i + 1];

				parametersComments += "\n\t\t// " + parameterType + " "
						+ parameterName + ";\n";

				parametersDeclaration += parameterName;
			}

		}

		String classDeclaration = "\n\t\t// ";

		if (method.getModifiers().contains(AddTodoClass.STATIC)) {

			classDeclaration += classFile.getClassDoc().getClassName();

		} else {

			classDeclaration += "new " + classFile.getClassDoc().getClassName()
					+ "()";
		}

		classDeclaration += "." + method.getName() + "("
				+ parametersDeclaration + ");";

		return parametersComments + classDeclaration;
	}
}
