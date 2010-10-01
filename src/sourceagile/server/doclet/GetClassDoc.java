package sourceagile.server.doclet;

import java.io.File;

import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.Field;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.RootDoc;

public class GetClassDoc {

	public static final String TODO_TAG = "todo";

	public static final String FEATURE_TAG = "feature";

	public static RootDoc getRootDoc(File file) {

		EasyDoclet doclet = new EasyDoclet(file, file);

		return doclet.getRootDoc();
	}

	public static ClassDocumentation getClassDoc(File file) {

		RootDoc rootDoc = getRootDoc(file);

		ClassDocumentation classDocumentation = new ClassDocumentation();

		if (rootDoc != null) {
			ClassDoc[] classes = rootDoc.classes();

			if (classes != null && classes.length > 0) {
				ClassDoc classDoc = classes[0];

				classDocumentation.setDescription(classDoc.commentText());

				if (classDoc.superclass() != null) {

					classDocumentation.setSuperclass(classDoc.superclass()
							.toString());
				}

				classDocumentation.setModifiers(classDoc.modifiers());

				classDocumentation.setConstructors(GetClassMethods
						.listConstructors(classDoc.constructors()));

				classDocumentation.setMethods(GetClassMethods
						.listMethods(classDoc.methods()));

				classDocumentation.setFields(listFields(classDoc.fields()));

				String[] imports = listImports(classDoc.importedClasses());

				if (classDoc.tags(TODO_TAG).length > 0) {

					classDocumentation.setTodo(true);
				}

				if (classDoc.tags(FEATURE_TAG).length > 0) {

					classDocumentation.setFeature(true);
				}

				classDocumentation.setImports(imports);
			}
		}

		return classDocumentation;
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
