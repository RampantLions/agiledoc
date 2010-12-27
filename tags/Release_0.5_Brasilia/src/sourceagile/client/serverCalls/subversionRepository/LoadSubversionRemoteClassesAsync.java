package sourceagile.client.serverCalls.subversionRepository;

import java.util.ArrayList;

import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadSubversionRemoteClassesAsync {

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
