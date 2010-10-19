package sourceagile.client.userFeatures.documentation;

import sourceagile.client.userFeatures.project.ProjectInitialization;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

public class ExportXML {

	public static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	public static final String FEATURES = "features";
	public static final String PROJECT = "project";
	public static final String FEATURE = "feature";
	public static final String CLASS_NAME = "className";
	public static final String CLASS_PATH = "classPath";
	public static final String FEATURE_NAME = "featureName";
	public static final String DESCRIPTION = "description";

	public static SyntaxHighlightPanel getSyntaxPanel(String xmlContent,
			String title) {

		SyntaxHighlightPanel syntaxPanel = new SyntaxHighlightPanel(xmlContent,
				SyntaxHighlightPanel.SYNTAX_XML);

		syntaxPanel.setSize(700, 600);
		syntaxPanel.setTitle(title);
		syntaxPanel.setAutoScroll(true);

		return syntaxPanel;
	}

	public static Element getFeaturesElement(Document xmlDocument) {

		Element featuresElement = xmlDocument.createElement(FEATURES);
		featuresElement.setAttribute(PROJECT,
				ProjectInitialization.currentProject.getName());

		return featuresElement;
	}

	public static Element getElement(Document xmlDocument, String elementName,
			String elementText) {

		Element element = xmlDocument.createElement(elementName);
		element.appendChild(xmlDocument.createTextNode(elementText));

		return element;
	}

}
