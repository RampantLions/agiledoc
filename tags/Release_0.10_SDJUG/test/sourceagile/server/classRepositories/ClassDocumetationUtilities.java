package sourceagile.server.classRepositories;

import java.util.Arrays;

import sourceagile.shared.entities.entry.ClassDocumentation;

import com.spun.util.StringUtils;

public class ClassDocumetationUtilities {
	public static String toString(ClassDocumentation doc) {

		return String.format("%s ThisClass extends %s\r\n"
				+ "description=%s\r\n imports=%s\r\n"
				+ " -- constructors --\r\n%s\r\n" + " -- fields --\r\n%s\r\n"
				+ " -- methods --\r\n%s\r\n" + " todo=%s]", doc.getModifiers(),
				doc.getSuperclass(), doc.getDescription(),
				Arrays.toString(doc.getImports()),
				prettyPrint(doc.getConstructors()),
				prettyPrint(doc.getFields()), prettyPrint(doc.getMethods()),
				doc.getClassStatus());
	}

	public static String prettyPrint(Object[] methods) {
		return StringUtils.toString("", methods);
	}
}
