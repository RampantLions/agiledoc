package agiledoc.server.remoteClassLoad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.shared.Feature;

public class RemoteClassLoad {

	public static Collection listRemoteClasses(SVNRepository repository,
			String path) throws SVNException {

		Collection entries = repository.getDir(path, -1, null,
				(Collection) null);

		return entries;
	}

	public static List<Feature> getFeaturesList(Collection entries) {

		List<Feature> features = new ArrayList<Feature>();

		Iterator iterator = entries.iterator();

		while (iterator.hasNext()) {

			SVNDirEntry entry = (SVNDirEntry) iterator.next();

			Feature feature = new Feature();

			feature.setName(entry.getName());
		//	feature.setDateModified(entry.getDate());
			
			features.add(feature);
		}

		return features;

	}
}
