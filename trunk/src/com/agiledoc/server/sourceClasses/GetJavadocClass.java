package com.agiledoc.server.sourceClasses;

import com.agiledoc.shared.model.Classe;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class GetJavadocClass {

	/**
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static String showClass(String root, String pack, Classe classe) {

		ClassDoc classDoc = GetClasse.getClasseDoc(root, pack, classe
				.getFullName());

		String html = classHeader(classDoc) + fieldSummary(classDoc)
				+ constructorSummary(classDoc) + methodSummary(classDoc);

		return html;
	}

	/**
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static String classHeader(ClassDoc classe) {

		String html = "<HR>" + "<!-- ======== START OF CLASS DATA ======== -->"
				+ "<H2>" + "<FONT SIZE=\"-1\">"
				+ classe.containingPackage().name() + "</FONT>" + "<BR>"
				+ "Class " + classe.name() + "</H2>" + "<PRE>"
				+ classe.superclass() + "<BR>"
				+ "<IMG SRC=\"resources/inherit.gif\" ALT=\"extended by \">"
				+ "<B>" + classe.toString() + "</B></PRE>";

		html += "<HR><DL>" + "<DT><PRE>" + classe.modifiers() + " class <B>"
				+ classe.name() + "</B><DT>" + classe.superclass() + "</DL>"
				+ "</PRE><P>" + classe.commentText() + "<P><P><HR>";

		return html;
	}

	/**
	 * @author allineo
	 * @modified 04/06/2010
	 */
	public static String fieldSummary(ClassDoc classe) {

		String html = "<!-- =========== FIELD SUMMARY =========== -->"
				+ "<A NAME=\"field_summary\"><!-- --></A>"
				+ "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" SUMMARY=\"\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Field Summary</B></FONT></TH></TR>";

		for (FieldDoc field : classe.fields()) {

			html += "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">"
					+ "<TD ALIGN=\"right\" VALIGN=\"top\" WIDTH=\"1%\"><FONT SIZE=\"-1\">"
					+ "<CODE>"
					+ field.type()
					+ "</CODE></FONT></TD>"
					+ "<TD><CODE><B><A HREF=\"../../../../../../org/paceproject/palms/browser/client/model/ObservationSetListUIEntity.html"
					+ "#" + field.name() + "\">" + field.name() + "</A></B>"
					+ "</CODE><BR></TD></TR>";

		}

		html += "</TABLE><BR><BR>";

		return html;
	}

	/**
	 * @author allineo
	 * @modified 04/06/2010
	 */
	public static String constructorSummary(ClassDoc classe) {

		String html = "<!-- ======== CONSTRUCTOR SUMMARY ======== -->"
				+ "<A NAME=\"constructor_summary\"><!-- --></A>"
				+ "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" SUMMARY=\"\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Constructor Summary</B></FONT></TH>" + "</TR>"
				+ "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">" + "<TD>";

		for (ConstructorDoc cd : classe.constructors()) {

			html += "<CODE><B><A HREF=\""
					+ "../../../../../../../org/paceproject/palms/browser/client/control/calculation/AddCalculation.html"
					+ "#" + cd.name() + "("
					+ getParameterString(cd.parameters()) + ")\">" + cd.name()
					+ "</A></B>" + "(" + getParameterString(cd.parameters())
					+ ")</CODE><BR>";

		}

		html += "</TD></TR></TABLE><BR><BR>";

		return html;
	}

	/**
	 * @author allineo
	 * @modified 04/07/2010
	 */
	private static String getParameterString(Parameter[] ps) {

		String result = "";

		for (int i = 0; i < ps.length; i++) {

			Type type = ps[i].type();

			String ename = type.isPrimitive() ? type.typeName() : type
					.asClassDoc().name();

			result += "<span class=jsdocParameterType>" + ename
					+ "</span> <span class=jsdocParameterName>" + ps[i].name()
					+ "</span>";

			if (i < ps.length - 1) {
				result += ", ";
			}
		}

		return result;
	}

	/**
	 * @author allineo
	 * @modified 04/07/2010
	 */
	public static String methodSummary(ClassDoc classe) {

		String html = "<!-- ========== METHOD SUMMARY =========== -->"
				+ "<A NAME=\"method_summary\"><!-- --></A>"
				+ "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" SUMMARY=\"\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Method Summary</B></FONT></TH>" + "</TR>";

		for (MethodDoc met : classe.methods()) {

			html += "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">"
					+ "<TD ALIGN=\"right\" VALIGN=\"top\" WIDTH=\"1%\"><FONT SIZE=\"-1\">"
					+ "<CODE>"
					+ met.returnType()
					+ "</CODE></FONT></TD>"
					+ "<TD><CODE><B><A HREF=\"../../../../../../org/paceproject/palms/browser/client/model/ObservationSetListUIEntity.html"
					+ "#" + met.name() + "("
					+ getParameterString(met.parameters()) + ")\">"
					+ met.name() + "</A></B>" + "("
					+ getParameterString(met.parameters()) + ")"
					+ "<BR>&nbsp;&nbsp;&nbsp;&nbsp;<span class=jsdocComment>"
					+ met.commentText() + "</span>" + "</CODE><BR></TD></TR>";
		}

		html += "</TABLE><BR><BR>";

		return html;

	}

}
