package sourceagile.server.repositoryClassLoader;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverConnection.RemoteLoadFunctions;
import sourceagile.shared.Entry;
import sourceagile.shared.Project;
import sourceagile.shared.User;

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
