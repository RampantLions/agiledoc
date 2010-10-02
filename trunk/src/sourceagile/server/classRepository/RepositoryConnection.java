package sourceagile.server.classRepository;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import sourceagile.shared.Project;
import sourceagile.shared.User;

/** 
 * Open a connection with the repository that was entered in the project data.
 *  
 */

public class RepositoryConnection {

	public static SVNRepository connect(Project project, User user)
			throws SVNException {

		DAVRepositoryFactory.setup();

		SVNRepository repository = SVNRepositoryFactory.create(SVNURL
				.parseURIDecoded(project.getRepositoryURL() + project.getRoot()
						+ project.getDomain()));
		ISVNAuthenticationManager authManager = SVNWCUtil
				.createDefaultAuthenticationManager(user.getName(),
						user.getPassword());
		repository.setAuthenticationManager(authManager);

		return repository;
	}

}
