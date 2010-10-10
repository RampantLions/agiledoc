package sourceagile.server.classRepository;

import java.util.ArrayList;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverConnection.LoadRemoteClasses;
import sourceagile.server.classRepository.repositoryEditor.CreateTodoClass;
import sourceagile.server.classRepository.repositoryEditor.UpdateClassDescription;
import sourceagile.server.classRepository.repositoryLoader.GetRepositoryClass;
import sourceagile.server.classRepository.repositoryLoader.ListRepositoryClasses;
import sourceagile.server.classRepository.repositoryLoader.ListRepositoryHistory;
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
			SVNRepository repository = RepositoryConnection
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

			SVNRepository repository = RepositoryConnection
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

			SVNRepository repository = RepositoryConnection
					.connectClassRepository(project, user);

			new CreateTodoClass(repository, classFile);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

	}

	@Override
	public void editClass(Project project, User user, ClassFile classFile,
			String classDescription) {

		try {

			SVNRepository repository = RepositoryConnection
					.connectClassRepository(project, user);

			new UpdateClassDescription(repository, classFile, classDescription);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

	}

	@Override
	public ArrayList<Productivity> listHistory(Project project, User user) {

		ArrayList<Productivity> productivity = null;

		try {
			SVNRepository repository = RepositoryConnection
					.connectClassRepository(project, user);

			productivity = ListRepositoryHistory.getRemoteClasses(project,
					repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return productivity;
	}

	@Override
	public ClassFile getTestClass(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = RepositoryConnection
					.connectTestRepository(project, user);

			entry = GetRepositoryClass.getClassFile(repository, entry);

		} catch (Exception e) {

			entry = null;
		}

		return entry;
	}

}
