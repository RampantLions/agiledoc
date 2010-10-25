package sourceagile.client.serverCalls.test;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadRemoteTestClassesAsync {

	void getTestClass(Project project, User user, ClassFile entry,
			AsyncCallback<ClassFile> callback);

	void addTestClass(Project project, User user, ClassFile entry,
			String newSubfolderName, AsyncCallback<Void> callback);

}
