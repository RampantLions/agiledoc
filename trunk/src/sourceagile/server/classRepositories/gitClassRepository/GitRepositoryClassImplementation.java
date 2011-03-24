package sourceagile.server.classRepositories.gitClassRepository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClasses;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.nyu.cs.javagit.api.DotGit;
import edu.nyu.cs.javagit.api.JavaGitException;
import edu.nyu.cs.javagit.api.Ref;
import edu.nyu.cs.javagit.api.WorkingTree;

@SuppressWarnings("serial")
public class GitRepositoryClassImplementation extends RemoteServiceServlet
		implements LoadGitRemoteClasses {

	// @Override
	public HashMap<String, ClassFile> listClasses(Project project, User user) {

		HashMap<String, ClassFile> entries = null;

		/*
		 * FileRepositoryBuilder builder = new RepositoryBuilder(); Repository
		 * repository = builder.setGitDir("/my/git/directory")
		 * .readEnvironment() // scan environment GIT_* variables .findGitDir()
		 * // scan up the file system tree .build();
		 */

		try {

			File repositoryDirectory = new File(
					"https://github.com/allineo/TravelLog/blob/master/src/log4j.xml");

			DotGit dotGit = DotGit.getInstance(repositoryDirectory);
			WorkingTree wt = dotGit.getWorkingTree();
			Ref master = wt.getCurrentBranch();

			/*
			 * File gitDir = new
			 * File("https://github.com/allineo/TravelLog.git"); Repository repo
			 * = new Repository(gitDir);
			 * 
			 * String head = repo.getFullBranch(); if
			 * (head.startsWith("refs/heads/")) { // Print branch name with
			 * "refs/heads/" stripped. System.out.println("Current branch is " +
			 * repo.getBranch()); }
			 * 
			 * repo.close();
			 */
		} catch (IOException ex) {
			// The repository exists, but is inaccessible!
			ex.printStackTrace();
		} catch (JavaGitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * FileRepository repository = new FileRepository(
		 * "git@github.com:allineo/AgileHelp.git");
		 * 
		 * String branch = repository.getBranch(); File repositoryRoot =
		 * repository.getWorkTree(); repository.getWorkTree();
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try { DotGit dotGit = GitRepositoryConnection
		 * .connect("https://github.com/allineo/TravelLog.git"); //
		 * https://github.com/allineo/TravelLog.git
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
