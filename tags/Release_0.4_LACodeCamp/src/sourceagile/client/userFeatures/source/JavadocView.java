package sourceagile.client.userFeatures.source;

import sourceagile.client.userFeatures.documentation.classViewOptions.ClassVizualizationPanel;
import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Field;
import sourceagile.shared.Method;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the Javadoc of the class dynamic generated.
 * 
 * @feature
 */
public class JavadocView extends VerticalPanel {

	public JavadocView(ClassFile entry) {

		setWidth("700px");

		ClassVizualizationPanel.featureContent.clear();

		add(classHeader(entry));
		add(fieldSummary(entry.getClassDoc()));
		add(constructorSummary(entry.getClassDoc()));
		add(methodSummary(entry.getClassDoc()));

		ClassVizualizationPanel.featureContent.add(this);
	}

	public static HTML classHeader(ClassFile entry) {

		String html = "<HR>"
				+ "<H2>"
				+ "<FONT SIZE=\"-1\">"
				+ entry.getFilePath()
				+ "</FONT>"
				+ "<BR>"
				+ "Class "
				+ entry.getFileName()
				+ "</H2>"
				+ "<PRE>"
				+ entry.getClassDoc().getSuperclass()
				+ "<BR>"
				+ "<IMG SRC=\"images/inheritJavadoc.gif\" ALT=\"extended by \">"
				+ "<B>" + entry.getFilePath() + "." + entry.getFileName()
				+ "</B></PRE>";

		html += "<HR><DL>" + "<DT><PRE>" + entry.getClassDoc().getModifiers()
				+ " class <B>" + entry.getFileName() + "</B><DT>"
				+ entry.getClassDoc().getSuperclass() + "</DL>" + "</PRE><P>"
				+ entry.getClassDoc().getDescription() + "<P><P><HR>";

		return new HTML(html);
	}

	public static HTML fieldSummary(ClassDocumentation classDoc) {

		String html = "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\">"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Field Summary</B></FONT></TH></TR>";

		for (Field field : classDoc.getFields()) {

			html += "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">"
					+ "<TD ALIGN=\"right\" VALIGN=\"top\" WIDTH=\"1%\"><FONT SIZE=\"-1\">"
					+ "<CODE>" + field.getType() + "</CODE></FONT></TD>"
					+ "<TD><CODE><B><A HREF=\"\">" + field.getName()
					+ "</A></B>" + "</CODE><BR></TD></TR>";

		}

		html += "</TABLE><BR><BR>";

		return new HTML(html);
	}

	public static HTML constructorSummary(ClassDocumentation classDoc) {

		String html = "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" >"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Constructor Summary</B></FONT></TH>"
				+ "</TR>"
				+ "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\"><TD>";

		for (Method cd : classDoc.getConstructors()) {

			html += "<CODE><B><A HREF=\"\">" + cd.getName() + "</A></B>" + "("
					+ cd.getParameters() + ")</CODE><BR>";

		}

		html += "</TD></TR></TABLE><BR><BR>";

		return new HTML(html);
	}

	public static HTML methodSummary(ClassDocumentation classDoc) {

		String html = "<TABLE BORDER=\"1\" WIDTH=\"100%\" CELLPADDING=\"3\" CELLSPACING=\"0\" >"
				+ "<TR BGCOLOR=\"#CCCCFF\" CLASS=\"TableHeadingColor\">"
				+ "<TH ALIGN=\"left\" COLSPAN=\"2\"><FONT SIZE=\"+2\">"
				+ "<B>Method Summary</B></FONT></TH>" + "</TR>";

		for (Method met : classDoc.getMethods()) {

			html += "<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">"
					+ "<TD ALIGN=\"right\" VALIGN=\"top\" WIDTH=\"1%\"><FONT SIZE=\"-1\">"
					+ "<CODE>" + met.getReturnType() + "</CODE></FONT></TD>"
					+ "<TD><CODE><B><A HREF=\"\">" + met.getName() + "</A></B>"
					+ "(" + met.getParameters() + ")"
					+ "<BR>&nbsp;&nbsp;&nbsp;&nbsp;<span class=jsdocComment>"
					+ met.getDescription() + "</span>"
					+ "</CODE><BR></TD></TR>";
		}

		html += "</TABLE><BR><BR>";

		return new HTML(html);

	}

}
