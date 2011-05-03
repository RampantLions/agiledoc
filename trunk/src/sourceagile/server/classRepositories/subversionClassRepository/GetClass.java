package sourceagile.server.classRepositories.subversionClassRepository;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import sourceagile.server.classRepositories.subversionFileRepository.GetFileContent;
import sourceagile.server.doclet.ConvertClassContentToDocumentation;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

public class GetClass {

	public static ClassFile getClass(Project project, User user, ClassFile entry) {

		String sourceCode = GetFileContent.getClassFile(
				project.getRepositoryURL(), user.getName(), user.getPassword(),
				entry.toString());

		entry.setSourceCode(sourceCode);

		if (ClassFile.EXTENSION_JAVA.equals(entry.getFileExtension())) {

			JSONObject jsonClassDoc = ConvertClassContentToDocumentation
					.loadClassDocumentation(sourceCode, entry.getFileName());

			entry.setClassDoc(convertJsonToClassfile(jsonClassDoc));
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

}
