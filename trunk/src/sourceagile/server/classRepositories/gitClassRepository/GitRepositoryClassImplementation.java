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

	@Override
	public HashMap<String, ClassFile> listClasses(Project project, User user) {

		HashMap<String, ClassFile> entries = null;

		return entries;
	}
}
