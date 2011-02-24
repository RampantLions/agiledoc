package sourceagile.server.doclet;

import sourceagile.shared.entities.entry.Method;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;

public class GetClassMethods {

	/**
	 * List all the constructor methods of a class.
	 */
	public static Method[] listConstructors(ConstructorDoc[] methodsDoc) {

		Method[] meths = new Method[methodsDoc.length];

		for (int i = 0; i < methodsDoc.length; i++) {

			ConstructorDoc met = methodsDoc[i];

			meths[i] = new Method();

			meths[i].setName(met.name());
			// meths[i].setSpacedName(ChangeNames.spacedName(met.name()));
			meths[i].setParameters(getParameterString(met.parameters()));
			meths[i].setDescription(met.commentText());
			meths[i].setModifiers(met.modifiers());
		}

		return meths;
	}

	/**
	 * List all the methods of a class.
	 */
	public static Method[] listMethods(MethodDoc[] methodsDoc, String locale) {

		Method[] meths = new Method[methodsDoc.length];

		for (int i = 0; i < methodsDoc.length; i++) {

			MethodDoc met = methodsDoc[i];

			meths[i] = new Method();

			meths[i].setName(met.name());
			meths[i].setSpacedName(FeatureNameGenerator.spacedName(met.name(),
					locale));
			meths[i].setModifiers(met.modifiers());
			meths[i].setReturnType(met.returnType().toString());
			meths[i].setParameters(getParameterString(met.parameters()));
			meths[i].setDescription(met.commentText());
		}

		return meths;
	}

	/**
	 * Convert the parameter list in a String.
	 */
	private static String getParameterString(Parameter[] ps) {

		String result = "";

		for (int i = 0; i < ps.length; i++) {

			Type type = ps[i].type();

			String ename = type.isPrimitive() ? type.typeName() : type
					.asClassDoc().name();

			result += ename + " " + ps[i].name();

			if (i < ps.length - 1) {
				result += ", ";
			}
		}

		return result;
	}
}
