package sourceagile.server.classRepositories.subversionClassRepository;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

import sourceagile.shared.entities.User;
import sourceagile.shared.entities.project.Project;

/**
 * Open a connection with the repository that was entered in the project data.
 * 
 * @Architecture
 */
public class SubversionRepositoryConnection {

	public static SVNRepository connectClassRepository(Project project,
			User user) throws SVNException {

		String URI = project.getRepositoryURL() + project.getRoot()
				+ project.getDomain();

		return connect(URI, user);
	}

	public static SVNRepository connectTestRepository(Project project, User user)
			throws SVNException {

		String URI = project.getRepositoryURL() + project.getTestRoot()
				+ project.getDomain();

		return connect(URI, user);
	}

	public static SVNRepository connect(String URI, User user)
			throws SVNException {

		DAVRepositoryFactory.setup();

		SVNRepository repository = SVNRepositoryFactory.create(SVNURL
				.parseURIDecoded(URI));

		repository.setAuthenticationManager(new BasicAuthenticationManager(user
				.getName(), user.getPassword()));

		return repository;
	}

}
