package sourceagile.server.databaseAccess.Comments;

import java.util.HashMap;

import javax.jdo.PersistenceManager;

import sourceagile.documentation.client.export.serverCalls.AllCommentsServerCalls;
import sourceagile.server.databaseAccess.DatabaseConnection;
import sourceagile.shared.entities.Comments;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @Architecture
 */
@SuppressWarnings("serial")
public class CommentsDatabaseImplementation extends RemoteServiceServlet
		implements AllCommentsServerCalls {

	@Override
	public HashMap<String, Comments> listAllComments(Long projectID) {

		PersistenceManager persistenceManager = DatabaseConnection.connect();

		HashMap<String, Comments> comments = ListAllComments.list(
				persistenceManager, projectID);

		persistenceManager.close();

		return comments;
	}
}
