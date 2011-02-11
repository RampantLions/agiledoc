package sourceagile.client.serverCalls;

import java.util.ArrayList;
import java.util.HashMap;

import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("subversionRepositoryClassLoader")
public interface LoadRemoteClasses extends RemoteService {

	ClassFile getClass(Project project, User user, ClassFile entry);

	HashMap<String, ClassFile> listClasses(Project project, User user);

	void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName);

	HashMap<String, ClassFile> listComponentClasses(Project project, User user,
			String componentPath);

	ArrayList<Productivity> listHistory(Project project, User user);

	void editClass(Project project, User user, ClassFile classFile,
			String classDescription);
}
