package sourceagile.server.classRepository.repositoryEditor;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.ClassFile;

public class CreateTodoClass {

	public CreateTodoClass(SVNRepository repository, ClassFile classFile)
			throws SVNException {

		String fileName = classFile.getClassName() + ".java";

		new AddFile(repository, classFile.getClassPath(), fileName,
				classContent(classFile));
	}

	private String classContent(ClassFile classFile) {

		String classContent = "package "
				+ classFile.getClassDomain().replaceAll("/", "\\.") + "."
				+ classFile.getClassPath() + ";\n" + "\n" + "/** \n" + "* "
				+ classFile.getClassDoc().getDescription() + " \n" + "* @todo "
				+ " \n" + "*/\n" + "public class " + classFile.getClassName()
				+ " {\n" + "\n" + "}\n";

		return classContent;
	}

}
