package sourceagile.documentation.client.export;

import java.util.HashMap;
import java.util.List;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.Comments;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Method;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;
import com.gwtext.client.widgets.SyntaxHighlightPanel;

public class ExportXmlFile {

	private static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private static final String PROJECT = "project";
	private static final String PROJECT_ID = "projectID";
	private static final String PROJECT_NAME = "projectName";
	private static final String PROJECT_DOMAIN = "projectDomain";
	private static final String PROJECT_DESCRIPTION = "projectDescription";

	private static final String PROJECT_COMPONENTS = "projectComponents";
	private static final String PROJECT_COMPONENT = "projectComponent";
	private static final String COMPONENT_NAME = "componentName";
	private static final String COMPONENT_PATH = "componentPath";

	private static final String ENTRIES = "entries";
	private static final String ENTRY = "entry";
	private static final String FILE_NAME = "fileName";
	private static final String FILE_PATH = "filePath";
	private static final String FILE_AUTHOR = "fileAuthor";
	private static final String FILE_DATE = "fileDate";
	private static final String CLASS_NAME = "className";

	private static final String FEATURE_TYPE = "featureType";
	private static final String FEATURE_PATH = "featurePath";
	private static final String FEATURE_NAME = "featureName";
	private static final String FEATURE_FOLDER = "featureFolder";
	private static final String FEATURE_DESCRIPTION = "featureDescription";
	private static final String IS_TODO = "isTodo";

	private static final String METHODS = "methods";
	private static final String METHOD = "method";
	private static final String METHOD_NAME = "methodName";
	private static final String METHOD_DESCRIPTION = "methodDescription";

	private static final String COMMENTS = "comments";
	private static final String COMMENT = "comment";
	private static final String COMMENT_DATE = "commentName";
	private static final String COMMENT_DESCRIPTION = "commentDescription";

	public static String getEntriesXML(HashMap<String, Comments> comments) {

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
								projectComponent.getComponentPath())
						&& entry.getClassDoc() != null
						&& entry.getClassDoc().getClassName() != null) {

					Element entryElement = getEntryNode(xmlDocument, entry,
							projectComponent.getComponentPath());

					entryElement.appendChild(getElement(xmlDocument, FILE_NAME,
							entry.getFileName()));

					entryElement.appendChild(getElement(xmlDocument, FILE_PATH,
							entry.getFilePath()));

					entryElement.appendChild(getElement(xmlDocument,
							FILE_AUTHOR, entry.getUser().getNickName()));

					entryElement.appendChild(getElement(xmlDocument, FILE_DATE,
							entry.getDateModified().getTime() + ""));

					entryElement.appendChild(getElement(xmlDocument,
							CLASS_NAME, entry.getClassDoc().getClassName()));

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
							FEATURE_FOLDER, entry.getFeature()
									.getFeatureFolder()));

					entryElement.appendChild(getElement(xmlDocument,
							FEATURE_DESCRIPTION, entry.getClassDoc()
									.getDescription()));

					entryElement.appendChild(getMethodsElement(entry
							.getClassDoc().getMethods(), xmlDocument));

					entryElement.appendChild(getClassComments(xmlDocument,
							entry, comments));

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

		projectElement
				.appendChild(getElement(xmlDocument, PROJECT_ID,
						ProjectInitialization.currentProject.getProjectID()
								.toString()));

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

		String tagType = "";

		if (entry.getClassDoc() != null
				&& entry.getClassDoc().getTagType() != null) {

			tagType = entry.getClassDoc().getTagType();
		}

		entryElement.setAttribute(FEATURE_TYPE, tagType);

		entryElement.setAttribute(IS_TODO, (entry.getClassDoc().isTodo() + ""));

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

	private static Element getClassComments(Document xmlDocument,
			ClassFile entry, HashMap<String, Comments> comments) {

		Element commentsElement = xmlDocument.createElement(COMMENTS);

		Comments comment = comments.get(entry.toString());

		if (comment != null) {

			Element commentElement = xmlDocument.createElement(COMMENT);
			commentElement.appendChild(getElement(xmlDocument, COMMENT_DATE,
					comment.getCommentDate().toString()));
			commentElement.appendChild(getElement(xmlDocument,
					COMMENT_DESCRIPTION, comment.getCommentDescription()));

			commentsElement.appendChild(commentElement);
		}

		return commentsElement;
	}
}
