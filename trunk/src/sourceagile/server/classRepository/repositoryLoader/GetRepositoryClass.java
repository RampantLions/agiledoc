package sourceagile.server.classRepository.repositoryLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.doclet.GetClassDoc;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Feature;
import sourceagile.shared.utilities.FeatureNameGenerator;

public class GetRepositoryClass {

	public static ClassFile getFeature(SVNRepository repository, ClassFile entry)
			throws SVNException, IOException {

		ByteArrayOutputStream baos = getRemoteClass(repository, entry);

		entry.setTextContent(baos.toString());

		loadClassDocumentation(baos, entry);

		return entry;
	}

	public static void loadClassDocumentation(ByteArrayOutputStream baos,
			ClassFile entry) throws IOException {

		File file = getTempFile(baos, entry);

		entry.setClassDoc(GetClassDoc.getClassDoc(file));

		setEntryFeature(entry);
	}

	public static ByteArrayOutputStream getRemoteClass(
			SVNRepository repository, ClassFile entry) throws SVNException,
			IOException {

		String className = entry.toString();

		SVNProperties fileProperties = new SVNProperties();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		repository.getFile(className, -1, fileProperties, baos);

		return baos;
	}

	private static File getTempFile(ByteArrayOutputStream baos, ClassFile entry)
			throws IOException {

		File tempFile = null;

		tempFile = File.createTempFile(entry.getClassName(), ".java");

		OutputStream out = new FileOutputStream(tempFile);
		out.write(baos.toByteArray());
		out.close();

		return tempFile;
	}

	public static void setEntryFeature(ClassFile entry) {

		Feature feature = new Feature();

		feature.setFeatureFolder(FeatureNameGenerator.getLastNameSpaced(
				entry.getClassPath(), "/"));

		feature.setFeatureName(FeatureNameGenerator.getFileSpacedName(entry
				.getClassName()));

		entry.setFeature(feature);
	}

}
