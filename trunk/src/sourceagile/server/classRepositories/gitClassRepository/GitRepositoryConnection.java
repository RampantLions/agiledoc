package sourceagile.server.classRepositories.gitClassRepository;

import org.tmatesoft.svn.core.SVNException;

import edu.nyu.cs.javagit.api.DotGit;

public class GitRepositoryConnection {

	public static DotGit connect(String URI) throws SVNException {

		DotGit dotGit = DotGit.getInstance(URI);

		dotGit.init();

		return dotGit;
	}

}
