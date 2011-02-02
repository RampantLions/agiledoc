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

	void listClasses(Project project, User user,
			AsyncCallback<ClassFile[]> callback);

	void listComponentClasses(Project project, User user, String componentPath,
			AsyncCallback<HashMap<String, ClassFile>> callback);

	void listHistory(Project project, User user,
			AsyncCallback<ArrayList<Productivity>> callback);

	void editClass(Project project, User user, ClassFile classFile,
			String classDescription, AsyncCallback<Void> callback);

}
