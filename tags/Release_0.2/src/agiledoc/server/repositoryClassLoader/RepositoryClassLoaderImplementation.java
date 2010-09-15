package agiledoc.server.repositoryClassLoader;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.client.serverConnection.RemoteLoadFunctions;
import agiledoc.shared.Entry;
import agiledoc.shared.Project;
import agiledoc.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RepositoryClassLoaderImplementation extends RemoteServiceServlet
		implements RemoteLoadFunctions {

	@Override
	public Entry[] ListFeatures(Project project, User user) {

		Entry[] entries = null;

		try { 

			SVNRepository repository = RepositoryConnection.connect(project,
					user);

			entries = ListRepositoryClasses.getRemoteClasses(repository);

		} catch (SVNException e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	@Override
	public Entry getEntryFeature(Project project, User user, Entry entry) {

		try {

			SVNRepository repository = RepositoryConnection.connect(project,
					user);

			entry = GetRepositoryClass.getFeature(repository, entry);

		} catch (SVNException e) {

			System.out.println(e.toString());
		}

		return entry;
	}

}
