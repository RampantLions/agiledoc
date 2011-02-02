package sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;

/**
 * List all the files from the Subversion Repository
 * 
 */
public class ListRepositoryClasses {

	public static HashMap<String, ClassFile> listAllRepositoryFiles(
			SVNRepository repository) throws SVNException, IOException {

		HashMap<String, ClassFile> classFiles = new HashMap<String, ClassFile>();

		listRepositoryFolder(repository, "", classFiles);

		return classFiles;
	}

	public static void listRepositoryFolder(SVNRepository repository,
			String folderPath, HashMap<String, ClassFile> entries)
			throws SVNException, IOException {

		Collection subFolderEntries = repository.getDir(folderPath, -1, null,
				(Collection) null);

		listFilesFromFolder(repository, folderPath, subFolderEntries, entries);
	}

	private static void listFilesFromFolder(SVNRepository repository,
			String path, Collection subversionEntries,
			HashMap<String, ClassFile> entries) throws SVNException,
			IOException {

		Iterator iterator = subversionEntries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry subversionEntry = (SVNDirEntry) iterator.next();

			if (subversionEntry.getKind() != SVNNodeKind.FILE) {

				listRepositoryFolder(repository,
						getFolderPath(path, subversionEntry), entries);
			} else {

				ClassFile entry = getClassFromRepositoryFile(subversionEntry,
						path);
				// GetRepositoryClass.getClassFile(repository, entry);

				entries.put(entry.toString(), entry);
			}
		}
	}

	public static String getFolderPath(String path, SVNDirEntry subversionEntry) {

		String folderPath = (path.equals("")) ? subversionEntry.getName()
				: path + "/" + subversionEntry.getName();

		return folderPath;
	}

	private static ClassFile getClassFromRepositoryFile(
			SVNDirEntry subversionEntry, String folderPath) {

		ClassFile entry = new ClassFile();

		entry.setFilePath(folderPath);

		entry.setFileName(subversionEntry.getName());

		long date = subversionEntry.getDate().getTime();
		entry.setDateModified(new Date(date));

		User user = new User();
		user.setName(subversionEntry.getAuthor());
		entry.setUser(user);

		// GetRepositoryClass.setEntryFeature(entry);

		return entry;
	}

}
