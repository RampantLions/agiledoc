package sourceagile.server.databaseAccess.Comments;

import java.util.HashMap;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.Comments;

public class ListAllComments {

	public static HashMap<String, Comments> list(
			PersistenceManager persistenceManager, Long projectID) {

		Extent commentsExtent = persistenceManager
				.getExtent(
						sourceagile.server.databaseAccess.entities.Comments.class,
						true);

		String filter = "commentProject == projectID";

		Query query = persistenceManager.newQuery(commentsExtent, filter);

		query.declareParameters("Long projectID");

		List<sourceagile.server.databaseAccess.entities.Comments> commentsDatabase = (List<sourceagile.server.databaseAccess.entities.Comments>) query
				.execute(projectID);

		HashMap<String, Comments> comments = new HashMap<String, Comments>();

		for (sourceagile.server.databaseAccess.entities.Comments commentDatabase : commentsDatabase) {

			comments.put(commentDatabase.getCommentClass(),
					ConvertComments.getComment(commentDatabase));
		}

		return comments;
	}
}
