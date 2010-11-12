package sourceagile.documentation.client;

import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Method;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

public class ExportXML {

	private static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private static final String ENTRIES = "entries";
	private static final String PROJECT = "project";

	private static final String ENTRY = "entry";
	private static final String CLASS_NAME = "className";
	private static final String CLASS_PATH = "classPath";

	private static final String SPECIFICATION = "specification";
	private static final String FEATURE = "feature";
	private static final String FEATURE_PATH = "featurePath";
	private static final String FEATURE_NAME = "featureName";
	private static final String FEATURE_DESCRIPTION = "featureDescription";

	private static final String METHODS = "methods";
	private static final String METHOD = "method";
	private static final String METHOD_NAME = "methodName";
	private static final String METHOD_DESCRIPTION = "methodDescription";

	public static String getEntriesXML() {

		Document xmlDocument = XMLParser.createDocument();

		Element entriesElement = getEntriesElement(xmlDocument);
		xmlDocument.appendChild(entriesElement);

		String specificationPath = ProjectInitialization.currentProject
				.getSpecificationPath();

		for (ClassFile entry : ProjectInitialization.projectEntries) {

			if (!entry.getClassDoc().isTodo()) {

				Element entryElement = getEntryNode(xmlDocument, entry);

				entryElement.appendChild(getElement(xmlDocument, CLASS_NAME,
						entry.getClassDoc().getClassName()));

				entryElement.appendChild(getElement(xmlDocument, CLASS_PATH,
						entry.getClassDoc().getClassPackage()));

				String featurePath = "";
				if (entry.getFilePath().startsWith(specificationPath)) {

					featurePath = entry.getFilePath().substring(
							specificationPath.length());

					if (featurePath.length() > 0) {

						featurePath = featurePath.substring(1);
					}
				}

				entryElement.appendChild(getElement(xmlDocument, FEATURE_PATH,
						featurePath));

				entryElement.appendChild(getElement(xmlDocument, FEATURE_NAME,
						entry.getFeature().getFeatureName()));

				entryElement.appendChild(getElement(xmlDocument,
						FEATURE_DESCRIPTION, entry.getClassDoc()
								.getDescription()));

				entryElement.appendChild(getMethodsElement(entry.getClassDoc()
						.getMethods(), xmlDocument));

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

	private static Element getEntriesElement(Document xmlDocument) {

		Element entriesElement = xmlDocument.createElement(ENTRIES);
		entriesElement.setAttribute(PROJECT,
				ProjectInitialization.currentProject.getName());

		return entriesElement;
	}

	private static Element getEntryNode(Document xmlDocument, ClassFile entry) {

		String specificationPath = ProjectInitialization.currentProject
				.getSpecificationPath();

		Element entryElement = xmlDocument.createElement(ENTRY);

		boolean featureTag = false;
		if (entry.getClassDoc().getTagType() != null
				&& entry.getClassDoc().getTagType()
						.equals(ClassDocumentation.FEATURE_TAG)) {

			featureTag = true;
		}

		entryElement.setAttribute(FEATURE, String.valueOf(featureTag));

		entryElement.setAttribute(
				SPECIFICATION,
				String.valueOf(specificationPath != null
						&& entry.getFilePath().startsWith(specificationPath)));

		return entryElement;
	}

	private static Element getMethodsElement(Method[] methods,
			Document xmlDocument) {

		Element methodsElement = xmlDocument.createElement(METHODS);

		if (methods != null) {

			for (Method method : methods) {

				methodsElement
						.appendChild(getMethodElement(xmlDocument, method));
			}
		}

		return methodsElement;
	}

	private static Element getMethodElement(Document xmlDocument, Method method) {

		Element methodElement = xmlDocument.createElement(METHOD);
		methodElement.appendChild(getElement(xmlDocument, METHOD_NAME,
				method.getName()));
		methodElement.appendChild(getElement(xmlDocument, METHOD_DESCRIPTION,
				method.getDescription()));

		return methodElement;
	}

	private static Element getElement(Document xmlDocument, String elementName,
			String elementText) {

		Element element = xmlDocument.createElement(elementName);
		element.appendChild(xmlDocument.createTextNode(elementText));

		return element;
	}

}
