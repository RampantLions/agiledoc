package sourceagile.client.serverCalls.gitRepository;

import java.util.HashMap;

import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadGitRemoteClassesAsync {

	void listClasses(Project currentProject, User currentUser,
			AsyncCallback<HashMap<String, ClassFile>> asyncCallback);

}
