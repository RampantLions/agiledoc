package sourceagile.testing.client.serverCalls;

import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadRemoteTestClassesAsync {

	void getTestClass(Project project, User user, ClassFile entry,
			AsyncCallback<ClassFile> callback);

	void addTestClass(Project project, User user, ClassFile entry,
			String newSubfolderName, AsyncCallback<Void> callback);

}
