package sourceagile.documentation.client.serverCalls;

import java.util.HashMap;

import sourceagile.shared.entities.Comments;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @Architecture
 */
@RemoteServiceRelativePath("commentsDatabaseAccess")
public interface AllCommentsServerCalls extends RemoteService {

	HashMap<String, Comments> listAllComments(Long projectID);

}