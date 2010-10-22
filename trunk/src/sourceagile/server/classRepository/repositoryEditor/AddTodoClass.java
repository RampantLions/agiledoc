package sourceagile.server.classRepository.repositoryEditor;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;

public class AddTodoClass {

	public AddTodoClass(SVNRepository repository, ClassFile classFile)
			throws SVNException {

		String fileName = classFile.getFileName();

		String newSubFolderName = null;
		if (classFile.getFeature() != null) {

			newSubFolderName = classFile.getFeature().getFeatureFolder();
		}

		new AddFile(repository, classFile.getFilePath(), newSubFolderName,
				fileName, classContent(classFile));
	}

	private String classContent(ClassFile classFile) {

		String packName = classFile.getClassDomain().replaceAll("/", "\\.");

		if (classFile.getFilePath() != null
				&& classFile.getFilePath().length() > 0) {

			packName = packName + "."
					+ classFile.getFilePath().replaceAll("/", "\\.");
		}

		if (classFile.getFeature() != null) {

			packName = packName + "."
					+ classFile.getFeature().getFeatureFolder();
		}

		String classPackage = "package " + packName + ";\n" + "\n";

		String classDescription = "/** \n" + "* "
				+ classFile.getClassDoc().getDescription() + " \n" + "* \n"
				+ "* @" + ClassDocumentation.TODO_TAG + " \n" + "*/\n";

		String className = "public class " + classFile.getFileName() + " {\n"
				+ "\n" + "}\n";

		String classContent = classPackage + classDescription + className;

		return classContent;
	}
}
