package sourceagile.server.databaseAccess.Comments;

import java.util.Date;

import sourceagile.shared.entities.Comments;

public class ConvertComments {

	public static Comments getComment(
			sourceagile.server.databaseAccess.entities.Comments commentDatabase) {

		Comments comment = new Comments();

		comment.setCommmentID(commentDatabase.getCommmentID());

		comment.setCommentAuthor(commentDatabase.getCommentAuthor());

		comment.setCommentDate(new Date(commentDatabase.getCommentDate()
				.getTime()));

		comment.setCommentDescription(commentDatabase.getCommentDescription());

		comment.setCommentProject(commentDatabase.getCommentProject());

		comment.setCommentClass(commentDatabase.getCommentClass());

		return comment;
	}

	public static sourceagile.server.databaseAccess.entities.Comments getDatabaseComment(
			Comments comment) {

		sourceagile.server.databaseAccess.entities.Comments commentDatabase = new sourceagile.server.databaseAccess.entities.Comments();

		commentDatabase.setCommentAuthor(comment.getCommentAuthor());

		commentDatabase.setCommentDate(comment.getCommentDate());

		commentDatabase.setCommentDescription(comment.getCommentDescription());

		commentDatabase.setCommentProject(comment.getCommentProject());

		commentDatabase.setCommentClass(comment.getCommentClass());

		return commentDatabase;
	}

}
