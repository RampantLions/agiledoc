package agiledoc.server.repositoryClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.server.doclet.GetClassDoc;
import agiledoc.shared.Entry;

public class GetRepositoryClass {

	public static Entry getFeature(SVNRepository repository, Entry entry)
			throws SVNException {

		ByteArrayOutputStream baos = getRemoteClass(repository, entry);

		entry.setTextContent(baos.toString());

		String filePath = getRemoteFile(baos, entry);

		String domain = RepositoryConnection.domain + "."
				+ entry.getClassPath();

		entry.setClassDoc(GetClassDoc.getClassDoc(filePath, domain));

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

	public static String getRemoteFile(ByteArrayOutputStream baos, Entry entry)
			throws SVNException {

		File tempFile = null;
		try {

			tempFile = File.createTempFile(entry.getClassName(), ".java");

			String domainTempFile = RepositoryConnection.domain.replaceAll(
					"\\.", "/");

			String domain = "/" + domainTempFile + "/" + entry.getClassPath();

			new File(tempFile.getParent() + domain).mkdirs();

			File file = new File(tempFile.getParent() + domain + "/"
					+ entry.getClassName());

			OutputStream out = new FileOutputStream(file);
			out.write(baos.toByteArray());
			out.close();

		} catch (IOException ex) {

			System.err.println("Cannot create temp file: " + ex.getMessage());
		}

		return tempFile.getParent();
	}

}
