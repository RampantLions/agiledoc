package sourceagile.server.databaseAccess.Comments;

import java.util.HashMap;
import java.util.List;

import javax.jdo.PersistenceManager;

import sourceagile.development.client.serverCalls.CommentsServerCalls;
import sourceagile.documentation.client.serverCalls.AllCommentsServerCalls;
import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.shared.entities.Comments;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @Architecture
 */
@SuppressWarnings("serial")
public class CommentsDatabaseImplementation extends RemoteServiceServlet
		implements CommentsServerCalls, AllCommentsServerCalls {

	@Override
	public List<Comments> listClassComments(Long projectID, String classPath) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		List<Comments> comments = ListClassComments.list(persistenceManager,
				projectID, classPath);

		persistenceManager.close();

		return comments;
	}

	@Override
	public void saveComment(Comments comment) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		SaveComment.save(persistenceManager, comment);

		persistenceManager.close();
	}

	@Override
	public HashMap<String, Comments> listAllComments(Long projectID) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		HashMap<String, Comments> comments = ListAllComments.list(
				persistenceManager, projectID);

		persistenceManager.close();

		return comments;
	}
}
