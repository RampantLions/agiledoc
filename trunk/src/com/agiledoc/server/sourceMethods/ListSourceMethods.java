package com.agiledoc.server.sourceMethods;

import com.agiledoc.server.sourceClasses.GetClasse;
import com.agiledoc.server.sourceTags.SourceTags;
import com.agiledoc.server.util.ChangeNames;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.agiledoc.shared.model.Project;
import com.agiledoc.shared.model.Tag;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;

public class ListSourceMethods {

	/**
	 * List all the methods of a class.
	 */
	public static Method[] listMethods(Project proj, Classe classe) {

		ClassDoc classDoc = GetClasse.getClasseDoc(proj, classe.getFullName());

		MethodDoc[] methDoc = classDoc.methods();

		Method[] meths = new Method[methDoc.length];

		for (int i = 0; i < methDoc.length; i++) {

			MethodDoc met = methDoc[i];

			meths[i] = new Method();

			meths[i].setName(met.name());
			meths[i].setSpacedName(ChangeNames.spacedName(met.name()));
			meths[i].setReturnType(met.returnType().toString());
			meths[i].setParameters(getParameterString(met.parameters()));
			meths[i].setDescription(met.commentText());

			com.sun.javadoc.Tag[] tags = met.tags(Tag.LINK);
			meths[i].setLinks(SourceTags.list(tags));
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

			result += ename + ps[i].name();

			if (i < ps.length - 1) {
				result += ", ";
			}
		}

		return result;
	}
}
