package sourceagile.client.serverCalls.gitRepository;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadGitRemoteClassesAsync {

	void listClasses(Project project, User user,
			AsyncCallback<ClassFile[]> callback);

}
