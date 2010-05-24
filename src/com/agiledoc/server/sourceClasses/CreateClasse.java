package com.agiledoc.server.sourceClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;

public class CreateClasse {

	public CreateClasse(Project proj, Classe classe) throws Exception {

		String pack = classe.getPack().getFullName();

		String filePath = proj.getRoot() + "/" + pack.replace('.', '/') + "/"
				+ classe.getClasseDoc().getClassName().trim() + ".java";

		String javaClass = "package " + pack + ";\n" + "\n" + "/** \n" + "* "
				+ classe.getClasseDoc().getDescription() + " \n" + "* @todo "
				+ classe.getPriority() + " \n" + "*/\n" + "public class "
				+ classe.getClasseDoc().getClassName().trim() + " {\n" + "\n"
				+ "}\n";

		File f = new File(filePath);
		f.createNewFile();

		FileWriter fw = new FileWriter(f);
		PrintWriter outPrinter = new PrintWriter(fw);
		outPrinter.println(javaClass);
		outPrinter.close();
	}
}
