package sourceagile.server.classRepository.repositoryEditor;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;

public class AddTodoClass {

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

		String classPackage = "package " + packName + ";\n" + "\n";

		String classDescription = "/** \n" + "* "
				+ classFile.getClassDoc().getDescription() + " \n" + "* \n"
				+ "* @" + ClassDocumentation.TODO_TAG + " \n" + "*/\n";

		String className = "public class "
				+ classFile.getClassDoc().getClassName() + " {\n" + "\n"
				+ "}\n";

		String classContent = classPackage + classDescription + className;

		return classContent;
	}
}
