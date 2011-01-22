package sourceagile.documentation.client.export.serverCalls;

import java.util.HashMap;
import java.util.List;

import sourceagile.shared.entities.Comments;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @architecture
 */
@RemoteServiceRelativePath("commentsDatabaseAccess")
public interface CommentsServerCalls extends RemoteService {

	void saveComment(Comments comment);

	List<Comments> listClassComments(Long projectID, String classPath);

	HashMap<String, Comments> listAllComments(Long projectID);

}