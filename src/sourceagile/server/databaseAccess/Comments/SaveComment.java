package sourceagile.server.databaseAccess.Comments;

import javax.jdo.PersistenceManager;

import sourceagile.shared.entities.Comments;

public class SaveComment {

	public static void save(PersistenceManager persistenceManager,
			Comments comment) {

		persistenceManager.makePersistent(ConvertComments
				.getDatabaseComment(comment));
	}
}
