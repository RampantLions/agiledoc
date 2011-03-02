package sourceagile.server.doclet;

import java.io.File;

import sourceagile.server.doclet.easyDoclet.EasyDoclet;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.Field;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;

public class GetClassDoc {

	public static RootDoc getRootDoc(File file) {

		EasyDoclet doclet = new EasyDoclet(file, file);

		return doclet.getRootDoc();
	}

	public static ClassDocumentation getClassDoc(File file, String locale) {

		RootDoc rootDoc = getRootDoc(file);

		ClassDocumentation classDocumentation = new ClassDocumentation();

		if (rootDoc != null) {
			ClassDoc[] classes = rootDoc.classes();

			if (classes != null && classes.length > 0) {

				convertClassDoc(classDocumentation, classes[0], locale);
			}
		}

		return classDocumentation;
	}

	private static void convertClassDoc(ClassDocumentation classDocumentation,
			ClassDoc classDoc, String locale) {

		classDocumentation.setClassName(classDoc.name());

		classDocumentation.setClassPackage(classDoc.containingPackage().name());

		classDocumentation.setDescription(classDoc.commentText());

		if (classDoc.superclass() != null) {

			classDocumentation.setSuperclass(classDoc.superclass().toString());
		}

		classDocumentation.setModifiers(classDoc.modifiers());

		classDocumentation.setConstructors(GetClassMethods
				.listConstructors(classDoc.constructors()));

		classDocumentation.setMethods(GetClassMethods.listMethods(
				classDoc.methods(), locale));

		classDocumentation.setFields(listFields(classDoc.fields()));

		String[] imports = listImports(classDoc.importedClasses());

		if (classDoc.tags(ClassDocumentation.TODO_TAG).length > 0) {

			classDocumentation.setTodo(true);
		}

		if (classDoc.tags(ClassDocumentation.USER_MANUAL_TAG).length > 0) {

			classDocumentation.setTagType(ClassDocumentation.USER_MANUAL_TAG);

		} else if (classDoc.tags(ClassDocumentation.REQUIREMENT_TAG).length > 0) {

			classDocumentation.setTagType(ClassDocumentation.REQUIREMENT_TAG);

		} else if (classDoc.tags(ClassDocumentation.MAIN_FEATURE_TAG).length > 0) {

			classDocumentation.setTagType(ClassDocumentation.MAIN_FEATURE_TAG);

		} else if (classDoc.tags(ClassDocumentation.ARCHITECTURE_TAG).length > 0) {

			classDocumentation.setTagType(ClassDocumentation.ARCHITECTURE_TAG);

		} else if (classDoc.tags(ClassDocumentation.ENTITY_TAG).length > 0) {

			classDocumentation.setTagType(ClassDocumentation.ENTITY_TAG);
		}

		classDocumentation.setImports(imports);
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
