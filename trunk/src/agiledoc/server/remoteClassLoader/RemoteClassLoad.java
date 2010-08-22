package agiledoc.server.remoteClassLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.shared.Entry;

public class RemoteClassLoad {

	public static Collection listRemoteClasses(SVNRepository repository,
			String path) throws SVNException {

		Collection SVNEntries = repository.getDir(path, -1, null,
				(Collection) null);

		return SVNEntries;
	}

	public static List<Entry> getFeaturesList(Collection SVNEntries) {

		List<Entry> entries = new ArrayList<Entry>();

		Iterator iterator = SVNEntries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry SVNEntry = (SVNDirEntry) iterator.next();

			Entry entry = EntryFromSVNEntry(SVNEntry);

			entries.add(entry);
		}

		return entries;

	}

	public static Entry EntryFromSVNEntry(SVNDirEntry SVNEntry) {

		Entry entry = new Entry();

		entry.setEntryName(SVNEntry.getName());

		if (SVNEntry.getKind() == SVNNodeKind.FILE) {

			entry.setFile(true);
		}
		// feature.setDateModified(entry.getDate());

		return entry;
	}

}
