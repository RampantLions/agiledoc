package agiledoc.server.doclet;

import java.io.File;

import agiledoc.shared.ClassDocumentation;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

public class GetClassDoc {

	public static RootDoc getRootDoc(File file) {

		EasyDoclet doclet = new EasyDoclet(file, file);

		return doclet.getRootDoc();
	}

	public static ClassDocumentation getClassDoc(File file, String className) {

		RootDoc rootDoc = getRootDoc(file);

		ClassDoc[] classes = rootDoc.classes();
		
		ClassDoc classDoc = rootDoc.classNamed(className);

		ClassDocumentation classDocumentation = new ClassDocumentation();

		String[] imports = listImports(classDoc.importedClasses());

		classDocumentation.setImports(imports);

		return classDocumentation;
	}

	private static String[] listImports(ClassDoc[] imports) {

		String[] importsString = new String[imports.length];

		for (int t = 0; t < imports.length; t++) {

			importsString[t] = imports[t].toString();
		}

		return importsString;
	}

}
