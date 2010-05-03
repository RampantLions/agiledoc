package com.agiledoc.server.sourceClasses;

import com.agiledoc.server.systemRoot.GetSystemRoot;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

public class ListSourceClasses {

	public static Classe[] ListClasses(Project proj) {

		RootDoc rootDoc = GetSystemRoot.GetRootDoc(proj);

		ClassDoc[] classesDoc = rootDoc.classes();

		Classe[] classes = new Classe[classesDoc.length];

		for (int i = 0; i < classesDoc.length; ++i) {

			classes[i] = GetClasse.createClasse(classesDoc[i]);

			try {
				classes[i].setImports(listImports(classesDoc[i]
						.importedClasses()));
			} catch (Exception e) {
				// TODO: handle exception
			}

			classes[i].setDateModified(GetFileClasse.getLastModified(proj
					.getRoot(), classes[i]));

			classes[i].setMethods(ListSourceMethods.listMethods(classesDoc[i]
					.methods()));
		}

		return classes;
	}

	private static String[] listImports(ClassDoc[] imports) {

		String[] importsString = new String[imports.length];

		for (int t = 0; t < imports.length; t++) {

			importsString[t] = imports[t].toString();
		}

		return importsString;
	}
}
