package sourceagile.server.classRepositories.subversionClassRepository;

import sourceagile.server.classRepositories.subversionFileRepository.AddFile;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

public class AddTodoClass {

	public static final String PACKAGE = "package";
	public static final String PUBLIC = "public";
	public static final String CLASS = "class";
	public static final String EXTENDS = "extends";
	public static final String STATIC = "static";
	public static final String VOID = "void";
	public static final String NEW = "new";

	public AddTodoClass(Project project, User user, ClassFile classFile,
			String newSubfolderName) {

		AddFile.save(project.getRepositoryURL(), user.getName(),
				user.getPassword(), classFile.getFilePath(), newSubfolderName,
				classFile.getFileName(),
				classContent(classFile, newSubfolderName));
	}

	private String classContent(ClassFile classFile, String newSubfolderName) {

		String packName = classFile.getClassDomain().replaceAll("/", "\\.");

		if (classFile.getFilePath() != null
				&& classFile.getFilePath().length() > 0) {

			packName = packName + "."
					+ classFile.getFilePath().replaceAll("/", "\\.");
		}

		if (newSubfolderName != null && newSubfolderName.length() > 0) {

			packName = packName + "." + newSubfolderName;
		}

		String classPackage = PACKAGE + " " + packName + ";\n" + "\n";

		String classDescription = "/** \n" + "* "
				+ classFile.getClassDoc().getDescription() + " \n" + "* \n"
				+ "* @" + ClassDocumentation.TODO_STATUS + " \n" + "*/\n";

		String className = PUBLIC + " " + CLASS + " "
				+ classFile.getClassDoc().getClassName() + " {\n" + "\n"
				+ "}\n";

		String classContent = classPackage + classDescription + className;

		return classContent;
	}
}
