package com.agiledoc.server.sourceClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;

public class CreateClasse {

	public CreateClasse(Project proj, Classe classe) throws Exception {

		String pack = proj.getDomain() + "." + proj.getViewPackage() + "."
				+ classe.getPack().getName().toLowerCase();

		String filePath = proj.getRoot() + "/" + pack.replace('.', '/') + "/"
				+ classe.getClassName().trim() + ".java";

		String javaClass = "package " + pack + ";\n" + "\n" + "/** \n" + "* "
				+ classe.getDescription() + " \n" + "* @todo \n" + "*/\n"
				+ "public class " + classe.getClassName().trim() + " {\n"
				+ "\n" + "}\n";

		File f = new File(filePath);
		f.createNewFile();

		FileWriter fw = new FileWriter(f);
		PrintWriter outPrinter = new PrintWriter(fw);
		outPrinter.println(javaClass);
		outPrinter.close();
	}
}
