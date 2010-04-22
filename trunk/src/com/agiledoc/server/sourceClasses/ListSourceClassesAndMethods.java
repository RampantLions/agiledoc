package com.agiledoc.server.sourceClasses;

import com.agiledoc.server.systemRoot.GetSystemRoot;
import com.agiledoc.shared.model.Classe;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

/**
 * @task
 */
public class ListSourceClassesAndMethods {

	public static Classe[] ListClasses(String root, String pack) {

		RootDoc rootDoc = GetSystemRoot.GetRootDoc(root, pack);

		ClassDoc[] classesDoc = rootDoc.classes();

		Classe[] classes = new Classe[classesDoc.length];

		for (int i = 0; i < classesDoc.length; ++i) {

			classes[i] = GetClasse.createClasse(classesDoc[i]);	

			classes[i].setDateModified(GetFileClasse.getLastModified(root,
					classes[i]));

			classes[i].setMethodsCount(classesDoc[i].methods().length);
		}

		return classes;
	}
}
