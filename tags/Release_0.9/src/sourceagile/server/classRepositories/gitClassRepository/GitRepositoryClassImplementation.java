package sourceagile.server.classRepositories.gitClassRepository;

import java.util.HashMap;

import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClasses;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class GitRepositoryClassImplementation extends RemoteServiceServlet
		implements LoadGitRemoteClasses {

	// @Override
	public HashMap<String, ClassFile> listClasses(Project project, User user) {

		HashMap<String, ClassFile> entries = null;

		/*
		 * try {
		 * 
		 * 
		 * FileRepository repository = new FileRepository(
		 * "git@github.com:allineo/AgileHelp.git");
		 * 
		 * String branch = repository.getBranch(); File repositoryRoot =
		 * repository.getWorkTree(); repository.getWorkTree();
		 * 
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * 
		 * try { DotGit dotGit = GitRepositoryConnection
		 * .connect("git://github.com/allineo/AgileHelp.git");
		 * 
		 * WorkingTree wt = dotGit.getWorkingTree();
		 * 
		 * wt.toString();
		 * 
		 * wt.getTree();
		 * 
		 * // entries = ListRepositoryClasses.getRemoteClasses(repository);
		 * 
		 * } catch (Exception e) {
		 * 
		 * System.out.println(e.toString()); }
		 */
		return entries;
	}

}
