package sourceagile.client.serverCalls;

import java.util.ArrayList;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Productivity;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadRemoteClassesAsync {

	void getClass(Project project, User user, ClassFile entry,
			AsyncCallback<ClassFile> callback);

	void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName, AsyncCallback<Void> callback);

	void listHistory(Project project, User user,
			AsyncCallback<ArrayList<Productivity>> callback);

	void listClasses(Project project, User user,
			AsyncCallback<ClassFile[]> callback);

	void editClass(Project project, User user, ClassFile classFile,
			String classDescription, AsyncCallback<Void> callback);

}
