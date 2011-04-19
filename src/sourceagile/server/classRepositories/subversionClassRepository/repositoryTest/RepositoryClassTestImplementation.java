package sourceagile.server.classRepositories.subversionClassRepository.repositoryTest;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.classRepositories.subversionClassRepository.SubversionRepositoryConnection;
import sourceagile.shared.entities.User;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;
import sourceagile.testing.client.serverCalls.LoadRemoteTestClasses;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RepositoryClassTestImplementation extends RemoteServiceServlet
		implements LoadRemoteTestClasses {

	@Override
	public ClassFile getTestClass(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			entry = GetRepositoryTestClass.getTestClassFile(repository, entry);

		} catch (Exception e) {

			entry = null;
		}

		return entry;
	}

	@Override
	public void addTestClass(Project project, User user, ClassFile entry,
			String newSubfolderName) {

		try {

			SVNRepository repository = SubversionRepositoryConnection.connect(
					project.getRepositoryURL(), user);

			new CreateTestClass(repository, entry, newSubfolderName);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

}
