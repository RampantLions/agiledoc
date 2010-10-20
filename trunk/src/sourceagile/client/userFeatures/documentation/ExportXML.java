package sourceagile.client.userFeatures.documentation;

import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.ClassFile;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

public class ExportXML {

	public static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	public static final String ENTRIES = "entries";
	public static final String PROJECT = "project";
	public static final String ENTRY = "entry";
	public static final String FEATURE = "feature";
	public static final String CLASS_NAME = "className";
	public static final String CLASS_PATH = "classPath";
	public static final String FEATURE_NAME = "featureName";
	public static final String DESCRIPTION = "description";

	public static String getEntriesXML() {

		Document xmlDocument = XMLParser.createDocument();

		Element entriesElement = getFeaturesElement(xmlDocument);
		xmlDocument.appendChild(entriesElement);

		String specificationPath = ProjectInitialization.currentProject
				.getSpecificationPath();

		for (ClassFile entry : ProjectInitialization.projectEntries) {

			if (specificationPath != null
					&& entry.getFilePath().startsWith(specificationPath)) {

				Element entryElement = xmlDocument.createElement(ENTRY);
				entryElement.setAttribute(FEATURE,
						String.valueOf(entry.getClassDoc().isFeature()));

				entryElement.appendChild(getElement(xmlDocument, CLASS_NAME,
						entry.getClassDoc().getClassName()));

				entryElement.appendChild(getElement(xmlDocument, CLASS_PATH,
						entry.getClassDoc().getClassPackage()));

				entryElement.appendChild(getElement(xmlDocument, FEATURE_NAME,
						entry.getFeature().getFeatureName()));

				entryElement.appendChild(getElement(xmlDocument, DESCRIPTION,
						entry.getClassDoc().getDescription()));

				entriesElement.appendChild(entryElement);
			}
		}

		return xmlHeader + xmlDocument.toString();
	}

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

		Element featuresElement = xmlDocument.createElement(ENTRIES);
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
