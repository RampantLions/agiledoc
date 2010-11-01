package sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;

public class AddTodoClass {

	public static final String PACKAGE = "package";
	public static final String PUBLIC = "public";
	public static final String CLASS = "class";
	public static final String EXTENDS = "extends";
	public static final String STATIC = "static";
	public static final String VOID = "void";
	public static final String NEW = "new";

	public AddTodoClass(SVNRepository repository, ClassFile classFile,
			String newSubfolderName) throws SVNException {

		String fileName = classFile.getFileName();

		new AddFile(repository, classFile.getFilePath(), newSubfolderName,
				fileName, classContent(classFile, newSubfolderName));
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
				+ "* @" + ClassDocumentation.TODO_TAG + " \n" + "*/\n";

		String className = PUBLIC + " " + CLASS + " "
				+ classFile.getClassDoc().getClassName() + " {\n" + "\n"
				+ "}\n";

		String classContent = classPackage + classDescription + className;

		return classContent;
	}
}
