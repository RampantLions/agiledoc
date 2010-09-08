package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.shared.Entry;
import agiledoc.shared.Project;
import agiledoc.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("repositoryClassLoader")
public interface RemoteLoadFunctions extends RemoteService {

	Entry getEntryFeature(Project project, User user, Entry entry);

	List<Entry> ListFeatures(Project project, User user);
}
