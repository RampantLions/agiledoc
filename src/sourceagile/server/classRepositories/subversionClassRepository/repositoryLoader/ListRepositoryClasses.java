package sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

	public static ClassFile[] listAllRepositoryFiles(SVNRepository repository)
			throws SVNException, IOException {

		List<ClassFile> entriesList = listRepositoryFolder(repository, "",
				new ArrayList<ClassFile>());

		ClassFile[] entries = sortClassesList(entriesList);

		return entries;
	}

	public static List<ClassFile> listRepositoryFolder(
			SVNRepository repository, String folderPath, List<ClassFile> entries)
			throws SVNException, IOException {

		Collection subFolderEntries = repository.getDir(folderPath, -1, null,
				(Collection) null);

		listFilesFromFolder(repository, folderPath, subFolderEntries, entries);

		return entries;
	}

	private static void listFilesFromFolder(SVNRepository repository,
			String path, Collection subversionEntries, List<ClassFile> entries)
			throws SVNException, IOException {

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

				entries.add(entry);
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

	public static ClassFile[] sortClassesList(List<ClassFile> entriesList) {

		ClassFile[] entries = new ClassFile[entriesList.size()];

		entriesList.toArray(entries);

		Arrays.sort(entries);

		return entries;
	}

}
