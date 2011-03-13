package sourceagile.client.serverCalls;

import java.util.Date;
import java.util.HashMap;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Feature;
import sourceagile.shared.entities.entry.Field;
import sourceagile.shared.entities.entry.Method;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

public class ConvertRemoteClassesXML {

	private static final String ENTRY = "entry";
	private static final String FILE_NAME = "fileName";
	private static final String FILE_PATH = "filePath";
	private static final String FILE_AUTHOR = "fileAuthor";
	private static final String FILE_DATE = "fileDate";
	private static final String FEATURE_TYPE = "featureType";
	private static final String CLASS_NAME = "className";

	private static final String FEATURE_FOLDER = "featureFolder";
	private static final String FEATURE_NAME = "featureName";
	private static final String FEATURE_DESCRIPTION = "featureDescription";
	private static final String IS_TODO = "isTodo";

	private static final String CONSTRUCTORS = "constructors";
	private static final String METHODS = "methods";
	private static final String METHOD = "method";
	private static final String METHOD_NAME = "methodName";
	private static final String METHOD_DESCRIPTION = "methodDescription";

	private static final String FIELD = "field";
	private static final String FIELD_NAME = "fieldName";
	private static final String FIELD_TYPE = "fieldType";

	public static HashMap<String, ClassFile> getClasses(String xmlContent) {

		Document xmlDoc = XMLParser.parse(xmlContent);
		XMLParser.removeWhitespace(xmlDoc);
		Element projectElement = xmlDoc.getDocumentElement();

		return getProjectEntries(projectElement);
	}

	private static HashMap<String, ClassFile> getProjectEntries(
			Element projectElement) {

		NodeList entries = projectElement.getElementsByTagName(ENTRY);

		HashMap<String, ClassFile> classFiles = new HashMap<String, ClassFile>();

		for (int i = 0; i < entries.getLength(); i++) {

			Element entryElement = (Element) entries.item(i);

			ClassFile classFile = getClassFileFromElement(entryElement);

			classFiles.put(classFile.toString(), classFile);
		}

		return classFiles;
	}

	private static ClassFile getClassFileFromElement(Element entryElement) {

		ClassFile classFile = new ClassFile();

		classFile.setFileName(entryElement.getElementsByTagName(FILE_NAME)
				.item(0).getChildNodes().toString());

		classFile.setFilePath(entryElement.getElementsByTagName(FILE_PATH)
				.item(0).getChildNodes().toString());

		if (entryElement.getElementsByTagName(FILE_DATE).item(0) != null) {

			classFile.setDateModified(new Date(new Long(entryElement
					.getElementsByTagName(FILE_DATE).item(0).getChildNodes()
					.toString())));
		}

		classFile.setUser(getFileUser(entryElement));

		classFile.setFeature(getClassFeature(entryElement));

		classFile.setClassDoc(getClassDocumentation(entryElement));

		return classFile;
	}

	private static User getFileUser(Element entryElement) {

		User user = new User();

		user.setName(entryElement.getElementsByTagName(FILE_AUTHOR).item(0)
				.getChildNodes().toString());

		return user;
	}

	private static Feature getClassFeature(Element entryElement) {

		Feature feature = new Feature();

		feature.setFeatureFolder(entryElement
				.getElementsByTagName(FEATURE_FOLDER).item(0).getChildNodes()
				.toString());

		feature.setFeatureName(entryElement.getElementsByTagName(FEATURE_NAME)
				.item(0).getChildNodes().toString());

		return feature;
	}

	private static ClassDocumentation getClassDocumentation(Element entryElement) {

		ClassDocumentation classDocumentation = new ClassDocumentation();

		classDocumentation.setClassName(entryElement
				.getElementsByTagName(CLASS_NAME).item(0).getChildNodes()
				.toString());

		classDocumentation.setTagType(entryElement.getAttribute(FEATURE_TYPE));

		classDocumentation.setTodo(Boolean.parseBoolean(entryElement
				.getAttribute(IS_TODO)));

		Element featureDescriptionElement = (Element) entryElement
				.getElementsByTagName(FEATURE_DESCRIPTION).item(0);

		if (featureDescriptionElement != null) {

			classDocumentation.setDescription(featureDescriptionElement
					.getChildNodes().toString());
		}

		classDocumentation.setConstructors(entryMethods(entryElement
				.getElementsByTagName(CONSTRUCTORS).item(0).getChildNodes()));

		classDocumentation.setMethods(entryMethods(entryElement
				.getElementsByTagName(METHODS).item(0).getChildNodes()));

		classDocumentation.setFields(getFields(entryElement));

		return classDocumentation;
	}

	private static Method[] entryMethods(NodeList xmlMethods) {

		Method[] methods = new Method[xmlMethods.getLength()];

		for (int i = 0; i < xmlMethods.getLength(); i++) {

			Element methodElement = (Element) xmlMethods.item(i);

			Method method = new Method();

			method.setName(methodElement.getElementsByTagName(METHOD_NAME)
					.item(0).getChildNodes().toString());

			method.setSpacedName(FeatureNameGenerator.spacedName(
					method.getName(),
					ProjectInitialization.currentProject.getProjectLocale()));

			method.setDescription(methodElement
					.getElementsByTagName(METHOD_DESCRIPTION).item(0)
					.getChildNodes().toString());

			methods[i] = method;
		}

		return methods;
	}

	private static Field[] getFields(Element entryElement) {

		NodeList xmlFields = entryElement.getElementsByTagName(FIELD);

		Field[] fields = new Field[xmlFields.getLength()];

		for (int i = 0; i < xmlFields.getLength(); i++) {

			Element fieldElement = (Element) xmlFields.item(i);

			Field field = new Field();

			field.setName(fieldElement.getElementsByTagName(FIELD_NAME).item(0)
					.getChildNodes().toString());

			field.setType(fieldElement.getElementsByTagName(FIELD_TYPE).item(0)
					.getChildNodes().toString());

			fields[i] = field;
		}

		return fields;
	}
}
