package sourceagile.server.classRepository.repositoryLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.Productivity;
import sourceagile.shared.Project;

public class ListRepositoryHistory {

	public static ArrayList<Productivity> getRemoteClasses(Project project,
			SVNRepository repository) throws SVNException {

		ArrayList<Productivity> productivityArray = new ArrayList<Productivity>();

		long startRevision = 0;
		long endRevision = -1; // HEAD (the latest) revision

		int totalClasses = 0;
		int totalActivity = 0;

		Collection logEntries = repository.log(new String[] { "" }, null,
				startRevision, endRevision, true, true);

		for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
			SVNLogEntry logEntry = (SVNLogEntry) entries.next();
			System.out.println("---------------------------------------------");
			System.out.println("revision: " + logEntry.getRevision());
			System.out.println("author: " + logEntry.getAuthor());
			System.out.println("date: " + logEntry.getDate());
			System.out.println("log message: " + logEntry.getMessage());

			Productivity productivity = new Productivity();

			long date = logEntry.getDate().getTime();
			productivity.setDate(new Date(date));

			if (logEntry.getChangedPaths().size() > 0) {
				System.out.println();
				System.out.println("changed paths:");
				Set changedPathsSet = logEntry.getChangedPaths().keySet();

				for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths
						.hasNext();) {

					SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry
							.getChangedPaths().get(changedPaths.next());

					if (entryPath.getKind() == SVNNodeKind.FILE
							&& entryPath.getPath().contains(
									project.getRoot() + project.getDomain())) {

						System.out
								.println(" "
										+ entryPath.getType()
										+ " "
										+ entryPath.getPath()
										+ ((entryPath.getCopyPath() != null) ? " (from "
												+ entryPath.getCopyPath()
												+ " revision "
												+ entryPath.getCopyRevision()
												+ ")"
												: ""));

						if (entryPath.getType() == SVNLogEntryPath.TYPE_ADDED) {

							// productivity.setClassesCount(productivity
							// .getClassesCount() + 1);
							totalClasses++;
							productivity.setClassesCount(totalClasses);
						}

						// productivity.setClassActivityCount(productivity
						// .getClassActivityCount() + 1);

						totalActivity++;
						productivity.setClassActivityCount(totalActivity + 1);
					}
				}
			}

			productivityArray.add(productivity);
		}

		return productivityArray;
	}
}
