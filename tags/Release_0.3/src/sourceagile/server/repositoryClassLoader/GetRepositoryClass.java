package sourceagile.server.repositoryClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.doclet.GetClassDoc;
import sourceagile.shared.Entry;
import sourceagile.shared.Feature;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.spun.util.ObjectUtils;
import com.spun.util.io.FileUtils;

public class GetRepositoryClass {

	public static Entry getFeature(SVNRepository repository, Entry entry)
			throws SVNException {
		entry.setTextContent(getRemoteClass(repository, entry));
		LoadFeatureFromRepository(entry);
		return entry;
	}

	public static void LoadFeatureFromRepository(Entry entry) {
		File file = getTempFile(entry);

		loadClassDocumentation(entry, file);

		setEntryFeature(entry);
	}

	public static void loadClassDocumentation(Entry entry, File file) {
		entry.setClassDoc(GetClassDoc.getClassDoc(file));
	}

	public static String getRemoteClass(SVNRepository repository, Entry entry)
			throws SVNException {

		String className = entry.getFullName();

		SVNProperties fileProperties = new SVNProperties();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		repository.getFile(className, -1, fileProperties, baos);

		String context = baos.toString();
		try {
			baos.close();
		} catch (IOException e) {
			ObjectUtils.throwAsError(e);
		}
		return context;
	}

	private static File getTempFile(Entry entry) {

		File tempFile = null;
		try {

			tempFile = File.createTempFile(entry.getClassName(), ".java");

			FileUtils.writeFile(tempFile, entry.getTextContent());

		} catch (IOException ex) {

			throw ObjectUtils.throwAsError(ex);
		}

		return tempFile;
	}

	public static void setEntryFeature(Entry entry) {

		Feature feature = new Feature();

		feature.setFeatureFolder(FeatureNameGenerator.getLastNameSpaced(
				entry.getClassPath(), "/"));

		feature.setFeatureName(FeatureNameGenerator.getFileSpacedName(entry
				.getClassName()));

		entry.setFeature(feature);
	}

}
