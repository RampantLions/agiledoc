package agiledoc.server.remoteClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.server.localClassLoader.GetClassDoc;
import agiledoc.shared.Entry;

public class GetRemoteClass {

	public static Entry getFeature(SVNRepository repository, Entry entry)
			throws SVNException {

		ByteArrayOutputStream baos = getRemoteClass(repository, entry);

		entry.setTextContent(baos.toString());

		File file = getRemoteFile(baos);

		String className = entry.getClassPath() + "." + entry.getClassName();

		entry.setClasseDoc(GetClassDoc.getClassDoc(file, className));

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

	public static File getRemoteFile(ByteArrayOutputStream baos)
			throws SVNException {

		File tempFile = null;
		try {

			tempFile = File.createTempFile("MyFile.txt", ".tmp");
			System.out.print("Created temporary file with name ");
			System.out.println(tempFile.getAbsolutePath());

			FileInputStream fileInputStream = new FileInputStream(tempFile);
			fileInputStream.read(baos.toByteArray());
			fileInputStream.close();

		} catch (IOException ex) {

			System.err.println("Cannot create temp file: " + ex.getMessage());
		}

		return tempFile;
	}

}
