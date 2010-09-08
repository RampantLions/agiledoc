package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.shared.Entry;
import agiledoc.shared.Project;
import agiledoc.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RemoteLoadFunctionsAsync {

	void getEntryFeature(Project project, User user, Entry entry,
			AsyncCallback<Entry> callback);

	void ListFeatures(Project project, User user,
			AsyncCallback<List<Entry>> callback);

}
