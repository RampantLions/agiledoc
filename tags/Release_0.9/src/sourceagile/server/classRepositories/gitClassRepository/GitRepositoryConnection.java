package sourceagile.server.classRepositories.gitClassRepository;

import edu.nyu.cs.javagit.api.DotGit;

public class GitRepositoryConnection {

	public static DotGit connect(String URI) {

		DotGit dotGit = DotGit.getInstance(URI);

		dotGit.init();

		return dotGit;
	}

}
