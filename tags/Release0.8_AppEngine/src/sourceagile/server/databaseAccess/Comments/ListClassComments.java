package sourceagile.server.databaseAccess.Comments;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import sourceagile.shared.entities.Comments;

public class ListClassComments {

	public static List<Comments> list(PersistenceManager persistenceManager,
			Long projectID, String classPath) {

		Extent commentsExtent = persistenceManager
				.getExtent(
						sourceagile.server.databaseAccess.entities.Comments.class,
						true);

		String filter = "commentProject == projectID && commentClass == classPath";

		Query query = persistenceManager.newQuery(commentsExtent, filter);

		query.declareParameters("Long projectID, String classPath");

		query.setOrdering("commentDate DESC");

		List<sourceagile.server.databaseAccess.entities.Comments> commentsDatabase = (List<sourceagile.server.databaseAccess.entities.Comments>) query
				.execute(projectID, classPath);

		List<Comments> comments = new ArrayList<Comments>();

		for (sourceagile.server.databaseAccess.entities.Comments commentDatabase : commentsDatabase) {

			comments.add(ConvertComments.getComment(commentDatabase));
		}

		return comments;
	}
}
