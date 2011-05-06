package sourceagile.server.classRepositories.subversionClassRepository;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import sourceagile.server.classRepositories.subversionFileRepository.GetFileContent;
import sourceagile.server.doclet.ConvertClassContentToDocumentation;
import sourceagile.server.doclet.GetClassMethods;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Field;
import sourceagile.shared.entities.entry.Method;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FeatureNameGenerator;

public class GetClass {

	public static ClassFile getClass(Project project, User user, ClassFile entry) {

		String sourceCode = GetFileContent.getContent(
				project.getRepositoryURL(), user.getName(), user.getPassword(),
				entry.toString());

		entry.setSourceCode(sourceCode);

		if (ClassFile.EXTENSION_JAVA.equals(entry.getFileExtension())) {

			JSONObject jsonClassDoc = ConvertClassContentToDocumentation
					.loadClassDocumentation(sourceCode, entry.getFileName());

			ClassDocumentation classDoc = convertJsonToClassfile(jsonClassDoc);

			try {

				classDoc.setClassStatus(getStatus(jsonClassDoc
						.getJSONArray(ConvertClassContentToDocumentation.CLASS_TAGS)));

				classDoc.setTagType(getClassType(jsonClassDoc
						.getJSONArray(ConvertClassContentToDocumentation.CLASS_TAGS)));

				classDoc.setImports(listImports(jsonClassDoc
						.getJSONArray(ConvertClassContentToDocumentation.CLASS_IMPORTS)));

				classDoc.setFields(listFields(jsonClassDoc
						.getJSONArray(ConvertClassContentToDocumentation.CLASS_FIELDS)));

				classDoc.setMethods(listMethods(
						jsonClassDoc
								.getJSONArray(ConvertClassContentToDocumentation.CLASS_METHODS),
						project.getProjectLocale()));

				classDoc.setConstructors(listMethods(
						jsonClassDoc
								.getJSONArray(ConvertClassContentToDocumentation.CLASS_CONSTRUCTORS),
						project.getProjectLocale()));

			} catch (JSONException e) {

				e.printStackTrace();
			}

			entry.setClassDoc(classDoc);
		}

		return entry;
	}

	private static ClassDocumentation convertJsonToClassfile(
			JSONObject jsonClassDoc) {

		ClassDocumentation classDoc = new ClassDocumentation();

		try {
			classDoc.setClassName(jsonClassDoc
					.getString(ConvertClassContentToDocumentation.CLASS_NAME));

			classDoc.setClassPackage(jsonClassDoc
					.getString(ConvertClassContentToDocumentation.CLASS_PACKAGE));

			classDoc.setDescription(jsonClassDoc
					.getString(ConvertClassContentToDocumentation.CLASS_DESCRIPTION));

			classDoc.setSuperclass(jsonClassDoc
					.getString(ConvertClassContentToDocumentation.SUPER_CLASS));

			classDoc.setModifiers(jsonClassDoc
					.getString(ConvertClassContentToDocumentation.CLASS_MODIFIERS));

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return classDoc;
	}

	private static Method[] listMethods(JSONArray jsonMethods, String locale) {

		Method[] meths = new Method[jsonMethods.length()];

		for (int i = 0; i < jsonMethods.length(); i++) {

			try {

				JSONObject jsonField = jsonMethods.getJSONObject(i);

				meths[i] = new Method();

				meths[i].setName(jsonField
						.getString(GetClassMethods.METHOD_NAME));

				meths[i].setModifiers(jsonField
						.getString(GetClassMethods.METHOD_MODIFIERS));

				meths[i].setParameters(jsonField
						.getString(GetClassMethods.METHOD_PARAMETERS));

				meths[i].setReturnType(jsonField
						.getString(GetClassMethods.METHOD_RETURN_TYPE));

				meths[i].setDescription(jsonField
						.getString(GetClassMethods.METHOD_DESCRIPTION));

				meths[i].setSpacedName(FeatureNameGenerator.spacedName(
						jsonField.getString(GetClassMethods.METHOD_NAME),
						locale));

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return meths;
	}

	private static Field[] listFields(JSONArray jsonFields) {

		Field[] fields = new Field[jsonFields.length()];

		for (int i = 0; i < jsonFields.length(); i++) {

			try {

				JSONObject jsonField = jsonFields.getJSONObject(i);

				fields[i] = new Field();

				fields[i]
						.setName(jsonField
								.getString(ConvertClassContentToDocumentation.FIELD_NAME));

				fields[i]
						.setType(jsonField
								.getString(ConvertClassContentToDocumentation.FIELD_TYPE));

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return fields;
	}

	private static String[] listImports(JSONArray jsonImports) {

		String[] imports = new String[jsonImports.length()];

		for (int i = 0; i < jsonImports.length(); i++) {

			try {

				imports[i] = jsonImports.getString(i);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return imports;
	}

	private static String getStatus(JSONArray jsonTags) {

		String tagStatus = null;

		for (int i = 0; i < jsonTags.length(); i++) {

			String tag;
			try {
				tag = jsonTags.getString(i).replaceAll("@", "");

				if (ClassDocumentation.TODO_STATUS.equals(tag)
						|| ClassDocumentation.INPROGRESS_STATUS.equals(tag)
						|| ClassDocumentation.BLOCKED_STATUS.equals(tag)) {

					tagStatus = tag;
				}

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return tagStatus;
	}

	private static String getClassType(JSONArray jsonTags) {

		String tagType = null;

		for (int i = 0; i < jsonTags.length(); i++) {

			try {

				String tag = jsonTags.getString(i).replaceAll("@", "");

				if (ClassDocumentation.MAIN_FEATURE_TAG.equals(tag)
						|| ClassDocumentation.FEATURE_TAG.equals(tag)
						|| ClassDocumentation.USER_INTERFACE_TAG.equals(tag)
						|| ClassDocumentation.ARCHITECTURE_TAG.equals(tag)
						|| ClassDocumentation.ENTITY_TAG.equals(tag)) {

					tagType = tag;
				}

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return tagType;
	}
}
