package com.agiledoc.server.sourceClasses;

import com.agiledoc.server.systemRoot.GetSystemRoot;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Classedoc;
import com.agiledoc.shared.model.Field;
import com.agiledoc.shared.model.Pack;
import com.agiledoc.shared.model.Project;
import com.agiledoc.shared.model.Tag;
import com.agiledoc.shared.util.ChangeNames;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
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

		classe.setClasseDoc(createClasseDoc(proj, classDoc));
		classe.setPack(createClassePackage(proj, classDoc));
		classe.setName(ChangeNames.getLastNameSpaced(classDoc.toString()));

		if (classDoc.tags(Tag.TODO).length > 0) {

			classe.setTask(Tag.TODO);

			String priority = classDoc.tags(Tag.TODO)[0].text();
			if (priority != null && !priority.equals("")) {

				classe.setPriority(Integer.parseInt(priority));
			}
		}

		classe.setDateModified(GetFileClasse.getLastModified(proj.getRoot(),
				classe));

		return classe;

	}

	/**
	 * Convert the source class into classe attributes.
	 */
	public static Pack createClassePackage(Project proj, ClassDoc classDoc) {

		String packName = classDoc.containingPackage().name();
		Pack pack = new Pack();
		pack.setFullName(packName);

		return pack;

	}

	/**
	 * Convert the source class into classeDoc attributes.
	 */
	public static Classedoc createClasseDoc(Project proj, ClassDoc classDoc) {

		Classedoc classe = new Classedoc();

		classe.setFullName(classDoc.toString());
		classe.setClassName(classDoc.name());
		classe.setDescription(classDoc.commentText());
		classe.setModifiers(classDoc.modifiers());

		if (classDoc.superclass() != null) {
			classe.setSuperclass(classDoc.superclass().toString());
		}

		try {
			classe.setImports(listImports(classDoc.importedClasses()));
		} catch (Exception e) {
			// TODO: handle exception
		}

		classe.setFields(listFields(classDoc.fields()));
		classe.setConstructors(ListSourceMethods.listConstructors(classDoc
				.constructors()));
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

	public static Field[] listFields(FieldDoc[] fieldDoc) {

		Field[] fields = new Field[fieldDoc.length];

		for (int i = 0; i < fieldDoc.length; i++) {

			FieldDoc field = fieldDoc[i];

			fields[i] = new Field();

			fields[i].setName(field.name());
			fields[i].setType(field.type().toString());
		}

		return fields;
	}
}
