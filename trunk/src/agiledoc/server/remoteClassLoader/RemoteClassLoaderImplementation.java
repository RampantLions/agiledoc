package agiledoc.server.remoteClassLoader;

import java.util.Collection;
import java.util.List;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.client.serverConnection.RemoteLoadFunctions;
import agiledoc.shared.Entry;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RemoteClassLoaderImplementation extends RemoteServiceServlet
		implements RemoteLoadFunctions {

	public List<Entry> ListFeatures() {

		List<Entry> entries = null;

		try {
			SVNRepository repository = RemoteSubversionConnection.connect();

			Collection remoteClasses = RemoteClassLoad.listRemoteClasses(
					repository, "");

			entries = RemoteClassLoad.getFeaturesList(remoteClasses);

		} catch (SVNException e) {
			// handle exception
		}

		return entries;
	}

}
