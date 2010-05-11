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

			classes[i] = GetClasse.createClasse(proj, classesDoc[i]);

		}

		return classes;
	}
}
