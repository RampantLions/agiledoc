package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.Date;
import java.util.HashMap;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import sourceagile.server.classRepositories.subversionFileRepository.ListRepositoryFiles;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Feature;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FeatureNameGenerator;

public class ListFiles {

	public static HashMap<String, ClassFile> listClasses(Project project,
			User user) {

		JSONArray jsonArray = ListRepositoryFiles.listEntries(
				project.getRepositoryURL(), user.getName(), user.getPassword());

		HashMap<String, ClassFile> entries = new HashMap<String, ClassFile>();

		for (int i = 0; i < jsonArray.length(); i++) {

			try {

				JSONObject jsonFileEntry = (JSONObject) jsonArray.get(i);

				ClassFile classFile = convertJsonToClassfile(jsonFileEntry);

				classFile.setClassLocale(project.getProjectLocale());

				classFile.setFeature(setEntryFeature(classFile));

				entries.put(classFile.toString(), classFile);

			} catch (JSONException e) {

				e.printStackTrace();
			}

		}

		return entries;
	}

	private static ClassFile convertJsonToClassfile(JSONObject jsonFileEntry) {

		ClassFile classFile = new ClassFile();

		try {
			classFile.setFilePath(jsonFileEntry
					.getString(ListRepositoryFiles.FOLDER));

			classFile.setFileName(jsonFileEntry
					.getString(ListRepositoryFiles.NAME));

			classFile.setDateModified(new Date(jsonFileEntry
					.getLong(ListRepositoryFiles.TIME)));

			User userAuthor = new User();
			userAuthor.setName(jsonFileEntry
					.getString(ListRepositoryFiles.AUTHOR));
			classFile.setUser(userAuthor);

			classFile.setFileExtension(getFileExtension(jsonFileEntry
					.getString(ListRepositoryFiles.NAME)));

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return classFile;

	}

	private static String getFileExtension(String fileName) {

		String extension = "";

		String[] names = fileName.split("\\.");

		if (names.length > 0) {

			extension = names[names.length - 1];
		}

		return extension;
	}

	private static Feature setEntryFeature(ClassFile entry) {

		Feature feature = new Feature();

		feature.setFeatureFolder(FeatureNameGenerator.getLastNameSpaced(
				entry.getFilePath(), "/", entry.getClassLocale()));

		feature.setFeatureName(FeatureNameGenerator.getFileSpacedName(
				entry.getFileName(), entry.getClassLocale()));

		return feature;
	}
}
