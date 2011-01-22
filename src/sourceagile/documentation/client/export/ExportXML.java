package sourceagile.documentation.client.export;

import java.util.List;

import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Method;
import sourceagile.shared.entities.project.ProjectComponents;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

public class ExportXML {

	private static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private static final String PROJECT = "project";
	private static final String PROJECT_NAME = "projectName";
	private static final String PROJECT_DOMAIN = "projectDomain";
	private static final String PROJECT_DESCRIPTION = "projectDescription";

	private static final String PROJECT_COMPONENTS = "projectComponents";
	private static final String PROJECT_COMPONENT = "projectComponent";
	private static final String COMPONENT_NAME = "componentName";
	private static final String COMPONENT_PATH = "componentPath";

	private static final String ENTRIES = "entries";
	private static final String ENTRY = "entry";
	private static final String CLASS_NAME = "className";
	private static final String CLASS_PATH = "classPath";

	private static final String FEATURE_TYPE = "featureType";
	private static final String FEATURE_PATH = "featurePath";
	private static final String FEATURE_NAME = "featureName";
	private static final String FEATURE_DESCRIPTION = "featureDescription";

	private static final String METHODS = "methods";
	private static final String METHOD = "method";
	private static final String METHOD_NAME = "methodName";
	private static final String METHOD_DESCRIPTION = "methodDescription";

	public static String getEntriesXML() {

		Document xmlDocument = XMLParser.createDocument();

		Element projectElement = getProjectElement(xmlDocument);

		Element componentsElement = xmlDocument
				.createElement(PROJECT_COMPONENTS);

		List<ProjectComponents> projectComponents = ProjectInitialization.currentProject
				.getProjectComponents();

		for (ProjectComponents projectComponent : projectComponents) {

			Element componentElement = xmlDocument
					.createElement(PROJECT_COMPONENT);

			componentElement.setAttribute(COMPONENT_NAME,
					projectComponent.getComponentName());

			componentElement.setAttribute(COMPONENT_PATH,
					projectComponent.getComponentPath());

			componentsElement.appendChild(componentElement);

			Element entriesElement = xmlDocument.createElement(ENTRIES);

			componentElement.appendChild(entriesElement);

			for (ClassFile entry : ProjectInitialization.projectEntries) {

				if (entry.getFilePath() != null
						&& entry.getFilePath().startsWith(
								projectComponent.getComponentPath())) {

					// if (!entry.getClassDoc().isTodo()) {

					Element entryElement = getEntryNode(xmlDocument, entry,
							projectComponent.getComponentPath());

					entryElement.appendChild(getElement(xmlDocument,
							CLASS_NAME, entry.getClassDoc().getClassName()));

					entryElement.appendChild(getElement(xmlDocument,
							CLASS_PATH, entry.getFilePath()));

					String featurePath = entry.getFilePath().substring(
							projectComponent.getComponentPath().length());

					if (featurePath.length() > 0) {

						featurePath = featurePath.substring(1);
					}

					entryElement.appendChild(getElement(xmlDocument,
							FEATURE_PATH, featurePath));

					entryElement.appendChild(getElement(xmlDocument,
							FEATURE_NAME, entry.getFeature().getFeatureName()));

					entryElement.appendChild(getElement(xmlDocument,
							FEATURE_DESCRIPTION, entry.getClassDoc()
									.getDescription()));

					entryElement.appendChild(getMethodsElement(entry
							.getClassDoc().getMethods(), xmlDocument));

					entriesElement.appendChild(entryElement);
				}
			}
		}

		projectElement.appendChild(componentsElement);

		xmlDocument.appendChild(projectElement);

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

	private static Element getProjectElement(Document xmlDocument) {

		Element projectElement = xmlDocument.createElement(PROJECT);

		projectElement.appendChild(getElement(xmlDocument, PROJECT_NAME,
				ProjectInitialization.currentProject.getName()));

		projectElement.appendChild(getElement(xmlDocument, PROJECT_DOMAIN,
				ProjectInitialization.currentProject.getDomain()));

		projectElement.appendChild(getElement(xmlDocument, PROJECT_DESCRIPTION,
				ProjectInitialization.currentProject.getDescription()));   

		return projectElement;
	}

	private static Element getEntryNode(Document xmlDocument, ClassFile entry,
			String specificationPath) {

		Element entryElement = xmlDocument.createElement(ENTRY);

		String tagType = entry.getClassDoc().getTagType();

		if (tagType == null) {

			tagType = "";
		}

		entryElement.setAttribute(FEATURE_TYPE, tagType);

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
