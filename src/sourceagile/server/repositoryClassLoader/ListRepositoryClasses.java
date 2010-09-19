package sourceagile.server.repositoryClassLoader;

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

import sourceagile.shared.ClassFile;
import sourceagile.shared.User;

public class ListRepositoryClasses {

	public static ClassFile[] getRemoteClasses(SVNRepository repository)
			throws SVNException, IOException {

		List<ClassFile> entriesList = getRepositoryClasses(repository, "",
				new ArrayList<ClassFile>());

		ClassFile[] entries = sortedEntries(entriesList);

		return entries;
	}

	public static List<ClassFile> getRepositoryClasses(SVNRepository repository,
			String folderPath, List<ClassFile> entries) throws SVNException,
			IOException {

		Collection subFolderEntries = repository.getDir(folderPath, -1, null,
				(Collection) null);

		listClasses(repository, folderPath, subFolderEntries, entries);

		return entries;
	}

	public static void listClasses(SVNRepository repository, String path,
			Collection subversionEntries, List<ClassFile> entries)
			throws SVNException, IOException {

		Iterator iterator = subversionEntries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry subversionEntry = (SVNDirEntry) iterator.next();

			if (!checkIfIsFile(subversionEntry)) {

				getRepositoryClasses(repository,
						getFolderPath(path, subversionEntry), entries);
			} else {

				ClassFile entry = getEntryFromRepositoryEntry(subversionEntry, path);
				GetRepositoryClass.getFeature(repository, entry);

				entries.add(entry);
			}
		}
	}

	public static String getFolderPath(String path, SVNDirEntry subversionEntry) {

		String folderPath = (path.equals("")) ? subversionEntry.getName()
				: path + "/" + subversionEntry.getName();

		return folderPath;
	}

	private static ClassFile getEntryFromRepositoryEntry(
			SVNDirEntry subversionEntry, String folderPath) {

		ClassFile entry = new ClassFile();

		entry.setClassPath(folderPath);

		entry.setClassName(subversionEntry.getName());

		long date = subversionEntry.getDate().getTime();
		entry.setDateModified(new Date(date));

		User user = new User();
		user.setName(subversionEntry.getAuthor());
		entry.setUser(user);

		GetRepositoryClass.setEntryFeature(entry);

		return entry;
	}

	private static boolean checkIfIsFile(SVNDirEntry subversionEntry) {

		if (subversionEntry.getKind() == SVNNodeKind.FILE) {

			return true;
		} else {

			return false;
		}
	}

	private static ClassFile[] sortedEntries(List<ClassFile> entriesList) {

		ClassFile[] entries = new ClassFile[entriesList.size()];

		entriesList.toArray(entries);

		Arrays.sort(entries);

		return entries;
	}

}
