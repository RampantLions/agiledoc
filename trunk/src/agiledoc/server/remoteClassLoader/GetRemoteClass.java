package agiledoc.server.remoteClassLoader;

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

public class GetRemoteClass {

	public static Entry getFeature(SVNRepository repository, Entry entry)
			throws SVNException {

		ByteArrayOutputStream baos = getRemoteClass(repository, entry);

		entry.setTextContent(baos.toString());

		File file = getRemoteFile(baos, entry);

		String className = entry.getClassPath() + "." + entry.getClassName();

		entry.setClassDoc(GetClassDoc.getClassDoc(file, className));

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

	public static File getRemoteFile(ByteArrayOutputStream baos, Entry entry)
			throws SVNException {

		File tempFile = null;
		try {

			tempFile = File.createTempFile(entry.getClassName(), ".java");
			System.out.print("Created temporary file with name ");
			System.out.println(tempFile.getAbsolutePath());

			OutputStream out = new FileOutputStream(tempFile);
			out.write(baos.toByteArray());
			out.close();

		} catch (IOException ex) {

			System.err.println("Cannot create temp file: " + ex.getMessage());
		}

		return tempFile;
	}

}
