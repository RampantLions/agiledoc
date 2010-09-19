package sourceagile.client.serverConnection;

import sourceagile.shared.Entry;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("repositoryClassLoader")
public interface RemoteLoadFunctions extends RemoteService {

	Entry getEntryFeature(Project project, User user, Entry entry);

	Entry[] ListFeatures(Project project, User user);
}
