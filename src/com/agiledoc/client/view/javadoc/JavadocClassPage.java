package com.agiledoc.client.view.javadoc;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Classedoc;
import com.agiledoc.shared.model.Field;
import com.agiledoc.shared.model.Method;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @todo 5
 * 
 */
public class JavadocClassPage extends VerticalPanel {

	public JavadocClassPage(Classe classe) {

		setWidth("700");

		add(classHeader(classe));
		add(fieldSummary(classe.getClasseDoc()));
		add(constructorSummary(classe.getClasseDoc()));
		add(methodSummary(classe.getClasseDoc()));
	}

	public static HTML classHeader(Classe classe) {

		String html = "<HR>" + "<!-- ======== START OF CLASS DATA ======== -->"
				+ "<H2>" + "<FONT SIZE=\"-1\">"
				+ classe.getPack().getFullName() + "</FONT>" + "<BR>"
				+ "Class " + classe.getClasseDoc().getClassName() + "</H2>"
				+ "<PRE>" + classe.getClasseDoc().getSuperclass() + "<BR>"
				+ "<IMG SRC=\"img/inherit.gif\" ALT=\"extended by \">" + "<B>"
				+ classe.toString() + "</B></PRE>";

		html += "<HR><DL>" + "<DT><PRE>" + classe.getClasseDoc().getModifiers()
				+ " class <B>" + classe.getClasseDoc().getClassName()
				+ "</B><DT>" + classe.getClasseDoc().getSuperclass() + "</DL>"
				+ "</PRE><P>" + classe.getClasseDoc().getDescription()
				+ "<P><P><HR>";

		return new HTML(html);
	}

	public static HTML fieldSummary(Classedoc classe) {

		String html = "<!-- =========== FIELD SUMMARY =========== -->"
				+ "<A NAME=\"field_summary\"><!-- --></A>"
				+ "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" SUMMARY=\"\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Field Summary</B></FONT></TH></TR>";

		for (Field field : classe.getFields()) {

			html += "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">"
					+ "<TD ALIGN=\"right\" VALIGN=\"top\" WIDTH=\"1%\"><FONT SIZE=\"-1\">"
					+ "<CODE>" + field.getType() + "</CODE></FONT></TD>"
					+ "<TD><CODE><B><A HREF=\" " + "#" + field.getName()
					+ "\">" + field.getName() + "</A></B>"
					+ "</CODE><BR></TD></TR>";

		}

		html += "</TABLE><BR><BR>";

		return new HTML(html);
	}

	public static HTML constructorSummary(Classedoc classe) {

		String html = "<!-- ======== CONSTRUCTOR SUMMARY ======== -->"
				+ "<A NAME=\"constructor_summary\"><!-- --></A>"
				+ "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" SUMMARY=\"\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Constructor Summary</B></FONT></TH>" + "</TR>"
				+ "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">" + "<TD>";

		for (Method cd : classe.getConstructors()) {

			html += "<CODE><B><A HREF=\""
					+ "../../../../../../../org/paceproject/palms/browser/client/control/calculation/AddCalculation.html"
					+ "#" + cd.getName() + "(" + cd.getParameters() + ")\">"
					+ cd.getName() + "</A></B>" + "(" + cd.getParameters()
					+ ")</CODE><BR>";

		}

		html += "</TD></TR></TABLE><BR><BR>";

		return new HTML(html);
	}

	public static HTML methodSummary(Classedoc classe) {

		String html = "<!-- ========== METHOD SUMMARY =========== -->"
				+ "<A NAME=\"method_summary\"><!-- --></A>"
				+ "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" SUMMARY=\"\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Method Summary</B></FONT></TH>" + "</TR>";

		for (Method met : classe.getMethods()) {

			html += "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">"
					+ "<TD ALIGN=\"right\" VALIGN=\"top\" WIDTH=\"1%\"><FONT SIZE=\"-1\">"
					+ "<CODE>"
					+ met.getReturnType()
					+ "</CODE></FONT></TD>"
					+ "<TD><CODE><B><A HREF=\"../../../../../../org/paceproject/palms/browser/client/model/ObservationSetListUIEntity.html"
					+ "#" + met.getName() + "(" + met.getParameters() + ")\">"
					+ met.getName() + "</A></B>" + "(" + met.getParameters()
					+ ")"
					+ "<BR>&nbsp;&nbsp;&nbsp;&nbsp;<span class=jsdocComment>"
					+ met.getDescription() + "</span>"
					+ "</CODE><BR></TD></TR>";
		}

		html += "</TABLE><BR><BR>";

		return new HTML(html);

	}

}
