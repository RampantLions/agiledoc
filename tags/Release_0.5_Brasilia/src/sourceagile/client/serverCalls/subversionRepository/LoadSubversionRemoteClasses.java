package sourceagile.client.serverCalls.subversionRepository;

import java.util.ArrayList;

import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("subversionRepositoryClassLoader")
public interface LoadSubversionRemoteClasses extends RemoteService {

	ClassFile getClass(Project project, User user, ClassFile entry);

	ClassFile[] listClasses(Project project, User user);

	ArrayList<Productivity> listHistory(Project project, User user);

	void editClass(Project project, User user, ClassFile classFile,
			String classDescription);

	void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName);
}