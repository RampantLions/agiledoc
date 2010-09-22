package sourceagile.server.classRepository.repositoryEditor;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.ClassFile;

public class CreateTodoClass {

	public CreateTodoClass(SVNRepository repository, ClassFile classFile)
			throws SVNException {

		String fileName = classFile.getClassName() + ".java";

		String newSubFolderName = null;
		if (classFile.getFeature() != null) {

			newSubFolderName = classFile.getFeature().getFeatureFolder();
		}

		new AddFile(repository, classFile.getClassPath(), newSubFolderName,
				fileName, classContent(classFile));
	}

	private String classContent(ClassFile classFile) {

		String packName = classFile.getClassDomain().replaceAll("/", "\\.");

		if (classFile.getClassPath() != null
				&& classFile.getClassPath().length() > 0) {

			packName = packName + "." + classFile.getClassPath();
		}

		if (classFile.getFeature() != null) {

			packName = packName + "."
					+ classFile.getFeature().getFeatureFolder();
		}

		String classPackage = "package " + packName + ";\n" + "\n";

		String classDescription = "/** \n" + "* "
				+ classFile.getClassDoc().getDescription() + " \n" + "* \n"
				+ "* @todo \n" + "*/\n";

		String className = "public class " + classFile.getClassName() + " {\n"
				+ "\n" + "}\n";

		String classContent = classPackage + classDescription + className;

		return classContent;
	}
}
