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

public class RemoteClassLoad {

	public static Collection listRemoteClasses(SVNRepository repository,
			String path) throws SVNException {

		Collection subversionEntries = repository.getDir(path, -1, null,
				(Collection) null);

		return subversionEntries;
	}

	public static List<Entry> getEntryList(Collection subversionEntries) {

		List<Entry> entries = new ArrayList<Entry>();

		Iterator iterator = subversionEntries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry subversionEntry = (SVNDirEntry) iterator.next();

			Entry entry = getEntryFromSVNEntry(subversionEntry);

			entries.add(entry);
		}

		return entries;

	}

	private static Entry getEntryFromSVNEntry(SVNDirEntry subversionEntry) {

		Entry entry = new Entry();

		entry.setEntryName(subversionEntry.getName());

		entry.setFile(checkIfIsFile(subversionEntry));

		// entry.setDateModified(entry.getDate());

		entry.setFeature(getFeature(subversionEntry));

		return entry;
	}

	private static boolean checkIfIsFile(SVNDirEntry subversionEntry) {

		if (subversionEntry.getKind() == SVNNodeKind.FILE) {

			return true;
		} else {

			return false;
		}
	}

	private static Feature getFeature(SVNDirEntry subversionEntry) {

		Feature feature = new Feature();

		feature.setFeatureName(getFeatureName(subversionEntry.getName()));

		return feature;
	}

	private static String getFeatureName(String subversionName) {

		String fileName = FeatureNameGenerator
				.removeFileExtension(subversionName);

		String featureName = FeatureNameGenerator.spacedName(fileName);

		return featureName;
	}

}
