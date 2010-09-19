package sourceagile.client.serverConnection;

import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RemoteLoadFunctionsAsync {

	void getEntryFeature(Project project, User user, ClassFile entry,
			AsyncCallback<ClassFile> callback);

	void ListFeatures(Project project, User user,
			AsyncCallback<ClassFile[]> callback);

}
