package sourceagile.documentation.client.export.serverCalls;

import java.util.HashMap;

import sourceagile.shared.entities.Comments;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @Architecture
 */
public interface AllCommentsServerCallsAsync {

	void listAllComments(Long projectID,
			AsyncCallback<HashMap<String, Comments>> callback);

}
