package sourceagile.client.serverCalls.test;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("repositoryTestClassLoader")
public interface LoadRemoteTestClasses extends RemoteService {

	ClassFile getTestClass(Project project, User user, ClassFile entry);

	void addTestClass(Project project, User user, ClassFile entry);

}
