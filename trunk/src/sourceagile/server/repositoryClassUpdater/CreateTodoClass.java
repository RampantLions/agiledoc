package sourceagile.server.repositoryClassUpdater;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;

public class CreateTodoClass {

	public CreateTodoClass(Project proj, ClassFile classFile) throws Exception {

		String classContent = "package " + classFile.getClassPath() + ";\n"
				+ "\n" + "/** \n" + "* "
				+ classFile.getClassDoc().getDescription() + " \n" + "* @todo "
				+ " \n" + "*/\n" + "public class " + classFile.getClassName()
				+ " {\n" + "\n" + "}\n";

		/*
		 * File f = new File(classFile.toString()); f.createNewFile();
		 * 
		 * 
		 * FileWriter fw = new FileWriter(f); PrintWriter outPrinter = new
		 * PrintWriter(fw); outPrinter.println(classContent);
		 * outPrinter.close();
		 */
	}
}
