package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.ArrayList;
import java.util.HashMap;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.AddTodoClass;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.EditClassDescription;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor.EditFile;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.GetRepositoryClass;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.ListRepositoryClasses;
import sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.ListRepositoryComponentClasses;
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
	public HashMap<String, ClassFile> listComponentClasses(Project project,
			User user, String componentPath) {

		HashMap<String, ClassFile> entries = null;

		try {
			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			entries = ListRepositoryComponentClasses
					.listRepositoryComponentFiles(repository, componentPath,
							project.getProjectLocale());

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	@Override
	public HashMap<String, ClassFile> listClasses(Project project, User user) {

		HashMap<String, ClassFile> entries = null;

		try {
			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			entries = ListRepositoryClasses.listAllRepositoryFiles(repository,
					project.getProjectLocale());

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entries;
	}

	@Override
	public ClassFile getClass(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			entry = GetRepositoryClass.getClassFile(repository, entry);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entry;
	}

	@Override
	public void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName) {

		try {

			SVNRepository repository = SubversionRepositoryConnection
					.connectClassRepository(project, user);

			new AddTodoClass(repository, classFile, newSubfolderName);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

	}

	@Override
	public void editClass(Project project, User user, ClassFile classFile,
			String classDescription) {

		try {

			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			new EditClassDescription(repository, classFile, classDescription);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

	@Override
	public void editSourceCode(Project project, User user, ClassFile classFile) {

		try {

			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			new EditFile(repository, classFile);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

	@Override
	public ArrayList<Productivity> listHistory(Project project, User user) {

		ArrayList<Productivity> productivity = null;

		try {
			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			productivity = ListRepositoryHistory.getRemoteClasses(project,
					repository);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return productivity;
	}

}
