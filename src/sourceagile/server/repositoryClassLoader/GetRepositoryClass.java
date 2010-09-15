package sourceagile.server.repositoryClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.doclet.GetClassDoc;
import sourceagile.shared.Entry;

public class GetRepositoryClass {

	public static Entry getFeature(SVNRepository repository, Entry entry)
			throws SVNException {

		ByteArrayOutputStream baos = getRemoteClass(repository, entry);

		entry.setTextContent(baos.toString());

		File file = getTempFile(baos, entry);

		entry.setClassDoc(GetClassDoc.getClassDoc(file));

		return entry;
	}

	public static ByteArrayOutputStream getRemoteClass(
			SVNRepository repository, Entry entry) throws SVNException {

		String className = entry.getClassPath() + "/" + entry.getClassName();

		SVNProperties fileProperties = new SVNProperties();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		repository.getFile(className, -1, fileProperties, baos);

		return baos;
	}

	private static File getTempFile(ByteArrayOutputStream baos, Entry entry) {

		File tempFile = null;
		try {

			tempFile = File.createTempFile(entry.getClassName(), ".java");

			OutputStream out = new FileOutputStream(tempFile);
			out.write(baos.toByteArray());
			out.close();

		} catch (IOException ex) {

			System.err.println("Cannot create temp file: " + ex.getMessage());
		}

		return tempFile;
	}

}
