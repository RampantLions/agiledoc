package sourceagile.server.databaseAccess.Comments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.Comments;

/**
 * List all the projects added in the system.
 */
public class ListClassComments {

	public static List<Comments> list(PersistenceManager persistenceManager,
			Long projectID, String classPath) {

		Extent commentsExtent = persistenceManager.getExtent(Comments.class,
				true);

		String filter = "commentProject == projectID && commentClass == classPath";

		Query query = persistenceManager.newQuery(commentsExtent, filter);

		query.declareParameters("Long projectID, String classPath");

		query.setOrdering("commentDate DESC");

		List<Comments> commentsDatabase = (List<Comments>) query.execute(
				projectID, classPath);

		List<Comments> comments = new ArrayList<Comments>();

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

			comments.add(comment);
		}

		return comments;
	}
}
