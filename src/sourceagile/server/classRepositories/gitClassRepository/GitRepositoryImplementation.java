package sourceagile.server.classRepositories.gitClassRepository;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;
import edu.nyu.cs.javagit.api.DotGit;
import edu.nyu.cs.javagit.api.WorkingTree;

@SuppressWarnings("serial")
public class GitRepositoryImplementation {

	// public class GitRepositoryImplementation extends RemoteServiceServlet
	// implements
	// LoadRemoteClasses {

	// @Override
	public ClassFile[] listClasses(Project project, User user) {

		ClassFile[] entries = null;

		try {
			DotGit dotGit = GitRepositoryConnection
					.connect("https://allineo@github.com/allineo/AgileHelp.git");

			WorkingTree wt = dotGit.getWorkingTree();

			// entries = ListRepositoryClasses.getRemoteClasses(repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entries;
	}

}
