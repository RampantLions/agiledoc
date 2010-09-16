package sourceagile.server.repositoryClassLoader;

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

import sourceagile.shared.Entry;
import sourceagile.shared.User;

public class ListRepositoryClasses {

	public static Entry[] getRemoteClasses(SVNRepository repository)
			throws SVNException {

		List<Entry> entriesList = new ArrayList<Entry>();

		getRepositoryClasses(repository, "", entriesList);

		Entry[] entries = sortedEntries(entriesList);

		return entries;
	}

	public static void getRepositoryClasses(SVNRepository repository,
			String folderPath, List<Entry> entries) throws SVNException {

		Collection subFolderEntries = repository.getDir(folderPath, -1, null,
				(Collection) null);

		listClasses(repository, folderPath, subFolderEntries, entries);
	}

	public static void listClasses(SVNRepository repository, String path,
			Collection subversionEntries, List<Entry> entries)
			throws SVNException {

		Iterator iterator = subversionEntries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry subversionEntry = (SVNDirEntry) iterator.next();

			if (!checkIfIsFile(subversionEntry)) {

				getRepositoryClasses(repository,
						getFolderPath(path, subversionEntry), entries);
			} else {

				entries.add(getEntryFromRepositoryEntry(subversionEntry, path));
			}
		}
	}

	public static String getFolderPath(String path, SVNDirEntry subversionEntry) {

		String folderPath = (path.equals("")) ? subversionEntry.getName()
				: path + "/" + subversionEntry.getName();

		return folderPath;
	}

	private static Entry getEntryFromRepositoryEntry(
			SVNDirEntry subversionEntry, String folderPath) {

		Entry entry = new Entry();

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

	private static Entry[] sortedEntries(List<Entry> entriesList) {

		Entry[] entries = new Entry[entriesList.size()];

		entriesList.toArray(entries);

		Arrays.sort(entries);

		return entries;
	}

}
