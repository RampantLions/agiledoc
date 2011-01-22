package sourceagile.server.databaseAccess.Comments;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.Comments;

public class ListAllComments {

	public static HashMap<String, Comments> list(
			PersistenceManager persistenceManager, Long projectID) {

		Extent commentsExtent = persistenceManager.getExtent(Comments.class,
				true);

		String filter = "commentProject == projectID";

		Query query = persistenceManager.newQuery(commentsExtent, filter);

		query.declareParameters("Long projectID");

		List<Comments> commentsDatabase = (List<Comments>) query
				.execute(projectID);

		HashMap<String, Comments> comments = new HashMap<String, Comments>();

		for (Comments commentDatabase : commentsDatabase) {

			Comments comment = new Comments();

			comment.setCommmentID(commentDatabase.getCommmentID());

			comment.setCommentAuthor(commentDatabase.getCommentAuthor());

			comment.setCommentDate(new Date(commentDatabase.getCommentDate()
					.getTime()));

			comment.setCommentDescription(commentDatabase
					.getCommentDescription());

			comment.setCommentProject(commentDatabase.getCommentProject());

			comment.setCommentClass(commentDatabase.getCommentClass());

			comments.put(commentDatabase.getCommentClass(), comment);
		}

		return comments;
	}
}
