package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.ArrayList;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddTodoClass;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.EditClassDescription;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.GetRepositoryClass;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.ListRepositoryClasses;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.ListRepositoryHistory;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Productivity;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RepositoryClassImplementation extends RemoteServiceServlet
		implements LoadRemoteClasses {

	@Override
	public ClassFile[] listClasses(Project project, User user) {

		ClassFile[] entries = null;

		try {
			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			entries = ListRepositoryClasses.getRemoteClasses(repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	@Override
	public ClassFile getClass(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			entry = GetRepositoryClass.getClassFile(repository, entry);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entry;
	}

	@Override
	public void createClass(Project project, User user, ClassFile classFile) {

		try {

			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			new AddTodoClass(repository, classFile);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

	}

	@Override
	public void editClass(Project project, User user, ClassFile classFile,
			String classDescription) {

		try {

			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			new EditClassDescription(repository, classFile, classDescription);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

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

}
