package sourceagile.client.serverCalls.gitRepository;

import java.util.HashMap;

import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gitRepositoryClassLoader")
public interface LoadGitRemoteClasses extends RemoteService {

	HashMap<String, ClassFile> listClasses(Project project, User user);

}
