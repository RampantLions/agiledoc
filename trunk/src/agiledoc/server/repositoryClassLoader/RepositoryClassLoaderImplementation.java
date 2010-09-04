package agiledoc.server.repositoryClassLoader;

import java.util.List;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.client.serverConnection.RemoteLoadFunctions;
import agiledoc.shared.Entry;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RepositoryClassLoaderImplementation extends RemoteServiceServlet
		implements RemoteLoadFunctions {

	public List<Entry> ListFeatures() {

		List<Entry> entries = null;

		try {

			SVNRepository repository = RepositoryConnection.connect();

			entries = ListRepositoryClasses.getRemoteClasses(repository);

		} catch (SVNException e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	public Entry getEntryFeature(Entry entry) {

		try {

			SVNRepository repository = RepositoryConnection.connect();

			entry = GetRepositoryClass.getFeature(repository, entry);

		} catch (SVNException e) {

			System.out.println(e.toString());
		}

		return entry;
	}

}
