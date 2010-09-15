package sourceagile.client.serverConnection;

import sourceagile.shared.Entry;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RemoteLoadFunctionsAsync {

	void getEntryFeature(Project project, User user, Entry entry,
			AsyncCallback<Entry> callback);

	void ListFeatures(Project project, User user,
			AsyncCallback<Entry[]> callback);

}
