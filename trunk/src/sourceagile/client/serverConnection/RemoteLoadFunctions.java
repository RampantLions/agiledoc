package sourceagile.client.serverConnection;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("repositoryClassLoader")
public interface RemoteLoadFunctions extends RemoteService {

	ClassFile getEntryFeature(Project project, User user, ClassFile entry);

	ClassFile[] ListFeatures(Project project, User user);

	void createClasse(Project project, User user, ClassFile classFile);
}
