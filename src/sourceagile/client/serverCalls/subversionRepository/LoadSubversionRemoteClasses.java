package sourceagile.client.serverCalls.subversionRepository;

import java.util.ArrayList;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Productivity;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("subversionRepositoryClassLoader")
public interface LoadSubversionRemoteClasses extends RemoteService {

	ClassFile getClass(Project project, User user, ClassFile entry);

	ClassFile[] listClasses(Project project, User user);

	void createClass(Project project, User user, ClassFile classFile);

	ArrayList<Productivity> listHistory(Project project, User user);

	void editClass(Project project, User user, ClassFile classFile,
			String classDescription);
}
