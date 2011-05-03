package sourceagile.client.serverCalls;

import java.util.ArrayList;
import java.util.HashMap;

import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadRemoteClassesAsync {

	void getClass(Project project, User user, ClassFile entry,
			AsyncCallback<ClassFile> callback);

	void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName, AsyncCallback<Void> callback);

	void listHistory(Project project, User user,
			AsyncCallback<ArrayList<Productivity>> callback);

	void editClass(Project project, User user, ClassFile classFile,
			String classDescription, AsyncCallback<Void> callback);

	void listClasses(Project currentProject, User currentUser,
			AsyncCallback<HashMap<String, ClassFile>> asyncCallback);

	void editSourceCode(Project project, User user, ClassFile classFile,
			AsyncCallback<Void> callback);

}
