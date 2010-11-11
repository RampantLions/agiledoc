package sourceagile.testing.client.serverCalls;

import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("repositoryTestClassLoader")
public interface LoadRemoteTestClasses extends RemoteService {

	ClassFile getTestClass(Project project, User user, ClassFile entry);

	void addTestClass(Project project, User user, ClassFile entry,
			String newSubfolderName);

}
