package com.agiledoc.server.sourceClasses;

import com.agiledoc.server.systemRoot.GetSystemRoot;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Pack;
import com.agiledoc.shared.model.Project;
import com.agiledoc.shared.model.Tag;
import com.agiledoc.shared.util.ChangeNames;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

public class GetClasse {

	/**
	 * Identify the source class document from the source code.
	 */
	public static ClassDoc getClasseDoc(Project proj, String className) {

		RootDoc rootDoc = GetSystemRoot.GetRootDoc(proj);

		ClassDoc classDoc = rootDoc.classNamed(className);

		return classDoc;
	}

	/**
	 * Read the class attributes from the source class document.
	 */
	public static Classe returnClasse(Project proj, String className) {

		ClassDoc classDoc = getClasseDoc(proj, className);

		if (classDoc != null) {

			return createClasse(proj, classDoc);

		} else {

			return null;
		}
	}

	/**
	 * Convert the source class into classe attributes.
	 */
	public static Classe createClasse(Project proj, ClassDoc classDoc) {

		Classe classe = new Classe();

		classe.setFullName(classDoc.toString());
		classe.setClassName(classDoc.name());
		classe.setName(ChangeNames.spacedName(classDoc.name()));
		classe.setDescription(classDoc.commentText());

		String packName = classDoc.containingPackage().name();
		Pack pack = new Pack();
		pack.setFullName(packName);
		pack.setName(ChangeNames.getLastNameSpaced(packName));
		classe.setPack(pack);

		classe.setModifiers(classDoc.modifiers());

		if (classDoc.tags(Tag.TODO).length > 0) {

			classe.setTask(Tag.TODO);
			// classe.setPriority(classDoc.tags(Tag.TODO)[0]);
		}

		try {
			classe.setImports(listImports(classDoc.importedClasses()));
		} catch (Exception e) {
			// TODO: handle exception
		}

		classe.setDateModified(GetFileClasse.getLastModified(proj.getRoot(),
				classe));

		classe.setMethods(ListSourceMethods.listMethods(classDoc.methods()));

		return classe;

	}

	private static String[] listImports(ClassDoc[] imports) {

		String[] importsString = new String[imports.length];

		for (int t = 0; t < imports.length; t++) {

			importsString[t] = imports[t].toString();
		}

		return importsString;
	}
}
