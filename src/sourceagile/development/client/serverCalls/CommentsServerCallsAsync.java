package sourceagile.development.client.serverCalls;

import java.util.HashMap;
import java.util.List;

import sourceagile.shared.entities.Comments;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @architecture
 */
public interface CommentsServerCallsAsync {

	void saveComment(Comments comment, AsyncCallback<Void> callback);

	void listClassComments(Long projectID, String classPath,
			AsyncCallback<List<Comments>> callback);

	void listAllComments(Long projectID,
			AsyncCallback<HashMap<String, Comments>> callback);

}
