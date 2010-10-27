package sourceagile.server.classRepositories.gitClassRepository;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.storage.file.FileRepository;

import sourceagile.client.serverCalls.gitRepository.LoadGitRemoteClasses;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class GitRepositoryClassImplementation extends RemoteServiceServlet
		implements LoadGitRemoteClasses {

	// @Override
	public ClassFile[] listClasses(Project project, User user) {

		ClassFile[] entries = null;

		try {

			FileRepository repository = new FileRepository(
					"git@github.com:allineo/AgileHelp.git");

			String branch = repository.getBranch();
			File repositoryRoot = repository.getWorkTree();
			repository.getWorkTree();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
