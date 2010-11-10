package sourceagile.server.classRepositories.subversionClassRepository.repositoryTest;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddFile;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddTodoClass;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Method;
import sourceagile.shared.utilities.FeatureNameGenerator;

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

		String classComment = "";
		if (classFile.getClassDoc().getDescription() != null
				&& classFile.getClassDoc().getDescription().length() > 0) {

			classComment = "/**\n * Test Class: "
					+ classFile.getClassDoc().getClassName() + ".\n * "
					+ classFile.getClassDoc().getDescription() + "\n *\n */\n";
		}

		String classDeclaration = AddTodoClass.PUBLIC + " "
				+ AddTodoClass.CLASS + " "
				+ classFile.getClassDoc().getClassName() + "Test "
				+ AddTodoClass.EXTENDS + " TestCase {\n" + "\n";

		String classContent = classPackage
				+ imports
				+ classComment
				+ classDeclaration
				+ testMethods(classFile, classFile.getClassDoc()
						.getConstructors())
				+ testMethods(classFile, classFile.getClassDoc().getMethods())
				+ "}\n";

		return classContent;
	}

	private String testMethods(ClassFile classFile, Method[] methods) {

		String methodsDeclarations = "";

		if (methods != null) {

			for (Method method : methods) {

				if (method.getModifiers().contains(AddTodoClass.PUBLIC)) {

					String methodComment = "";
					if (method.getDescription() != null
							&& method.getDescription().length() > 0) {

						methodComment = "/**\n * Test Method: "
								+ method.getName() + ".\n * "
								+ method.getDescription() + "\n *\n */\n";
					}

					String nameTestMethod = "test"
							+ (method.getName().substring(0, 1)).toUpperCase()
							+ method.getName().substring(1);

					String methodDeclaration = "\t" + AddTodoClass.PUBLIC + " "
							+ AddTodoClass.VOID + " " + nameTestMethod
							+ "() { \n"
							+ getClassDeclaration(classFile, method);

					String assertCommand = "";
					if (method.getReturnType() == null
							|| method.getReturnType().equals("void")) {

						assertCommand = "\n\n\t\t" + "assertTrue(true);";

					} else {

						assertCommand = "\n\n\t\t// " + "assertEquals("
								+ method.getName() + "Tested, null);";
					}

					methodsDeclarations += methodComment + methodDeclaration
							+ assertCommand + "\n\t}\n\n";
				}
			}
		}
		return methodsDeclarations;
	}

	private String getClassDeclaration(ClassFile classFile, Method method) {

		String parametersDeclaration = "";

		String parametersComments = "";

		if (method.getParameters() != null
				&& method.getParameters().length() > 0) {

			String[] splitedParameters = method.getParameters().split(",");

			for (int i = 0; i < splitedParameters.length; i++) {

				String[] parameterStructure = splitedParameters[i].split(" ");

				parametersComments += "\n\t\t// " + splitedParameters[i]
						+ ";\n";

				parametersDeclaration += parameterStructure[parameterStructure.length - 1];

				if (i != splitedParameters.length - 1) {

					parametersDeclaration += ",";
				}
			}
		}

		String classDeclaration = "\n\t\t// ";

		if (method.getReturnType() != null
				&& !method.getReturnType().equals("void")) {

			classDeclaration += FeatureNameGenerator.getLastName(
					method.getReturnType(), "\\.")
					+ " " + method.getName() + "Tested = ";
		}

		if (method.getModifiers().contains(AddTodoClass.STATIC)) {

			classDeclaration += classFile.getClassDoc().getClassName();

		} else {

			classDeclaration += "new " + classFile.getClassDoc().getClassName()
					+ "(";

			if (method.getReturnType() == null) {

				classDeclaration += parametersDeclaration;
			}

			classDeclaration += ")";
		}

		if (method.getReturnType() != null) {

			classDeclaration += "." + method.getName() + "("
					+ parametersDeclaration + ")";
		}

		classDeclaration += ";";

		return parametersComments + classDeclaration;
	}
}
