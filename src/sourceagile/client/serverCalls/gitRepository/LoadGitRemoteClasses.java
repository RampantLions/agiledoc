package sourceagile.client.serverCalls.gitRepository;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gitRepositoryClassLoader")
public interface LoadGitRemoteClasses extends RemoteService {

	ClassFile[] listClasses(Project project, User user);

}
