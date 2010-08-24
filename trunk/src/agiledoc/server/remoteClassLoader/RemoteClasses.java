package agiledoc.server.remoteClassLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.server.utilities.FeatureNameGenerator;
import agiledoc.shared.Entry;
import agiledoc.shared.Feature;

public class RemoteClasses {

	public static List<Entry> getRemoteClasses(SVNRepository repository)
			throws SVNException {

		List<Entry> entries = new ArrayList<Entry>();

		getFolderEntries(repository, "", entries);

		return entries;
	}

	public static void getFolderEntries(SVNRepository repository,
			String folderPath, List<Entry> entries) throws SVNException {

		Collection subFolderEntries = getRepositoryEntry(repository, folderPath);

		getClassesList(repository, folderPath, subFolderEntries, entries);
	}

	public static Collection getRepositoryEntry(SVNRepository repository,
			String path) throws SVNException {

		Collection subversionEntries = repository.getDir(path, -1, null,
				(Collection) null);

		return subversionEntries;
	}

	public static void getClassesList(SVNRepository repository, String path,
			Collection subversionEntries, List<Entry> entries)
			throws SVNException {

		Iterator iterator = subversionEntries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry subversionEntry = (SVNDirEntry) iterator.next();

			if (!checkIfIsFile(subversionEntry)) {

				getFolderEntries(repository,
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

		// entry.setDateModified(entry.getDate());

		setEntryFeature(entry);

		return entry;
	}

	private static boolean checkIfIsFile(SVNDirEntry subversionEntry) {

		if (subversionEntry.getKind() == SVNNodeKind.FILE) {

			return true;
		} else {

			return false;
		}
	}

	private static void setEntryFeature(Entry entry) {

		Feature feature = new Feature();

		feature.setFeatureFolder(FeatureNameGenerator.getLastNameSpaced(
				entry.getClassPath(), "/"));

		feature.setFeatureName(FeatureNameGenerator.getFileSpacedName(entry
				.getClassName()));

		entry.setFeature(feature);
	}

}
