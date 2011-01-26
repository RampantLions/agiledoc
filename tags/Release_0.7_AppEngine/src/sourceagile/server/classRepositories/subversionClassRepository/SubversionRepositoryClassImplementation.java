package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.ArrayList;
import java.util.HashMap;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.ListRepositoryClasses;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.ListRepositoryHistory;
import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @Architecture
 */
@SuppressWarnings("serial")
public class SubversionRepositoryClassImplementation extends
		RemoteServiceServlet implements LoadRemoteClasses {

	@Override
	public ClassFile[] listClasses(Project project, User user) {

		ClassFile[] entries = null;

		try {
			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			entries = ListRepositoryClasses.listAllRepositoryFiles(repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	@Override
	public ArrayList<Productivity> listHistory(Project project, User user) {

		ArrayList<Productivity> productivity = null;

		try {
			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			productivity = ListRepositoryHistory.getRemoteClasses(project,
					repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return productivity;
	}

	@Override
	public void editClass(Project project, User user, ClassFile classFile,
			String classDescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClassFile getClass(Project project, User user, ClassFile entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, ClassFile> listComponentClasses(Project project,
			User user, String componentPath) {
		// TODO Auto-generated method stub
		return null;
	}

}
