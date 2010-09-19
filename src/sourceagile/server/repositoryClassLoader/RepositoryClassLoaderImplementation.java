package sourceagile.server.repositoryClassLoader;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverConnection.RemoteLoadFunctions;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RepositoryClassLoaderImplementation extends RemoteServiceServlet
		implements RemoteLoadFunctions {

	@Override
	public ClassFile[] ListFeatures(Project project, User user) {

		ClassFile[] entries = null;

		try {
			SVNRepository repository = RepositoryConnection.connect(project,
					user);

			entries = ListRepositoryClasses.getRemoteClasses(repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	@Override
	public ClassFile getEntryFeature(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = RepositoryConnection.connect(project,
					user);

			entry = GetRepositoryClass.getFeature(repository, entry);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entry;
	}

}
