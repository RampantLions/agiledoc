package sourceagile.server.classRepository.repositoryTest;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverCalls.test.LoadRemoteTestClasses;
import sourceagile.server.classRepository.RepositoryConnection;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;
import sourceagile.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RepositoryClassTestImplementation extends RemoteServiceServlet
		implements LoadRemoteTestClasses {

	@Override
	public ClassFile getTestClass(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = RepositoryConnection
					.connectTestRepository(project, user);

			entry = GetRepositoryTestClass.getTestClassFile(repository, entry);

		} catch (Exception e) {

			entry = null;
		}

		return entry;
	}

	@Override
	public void addTestClass(Project project, User user, ClassFile entry) {

		try {

			SVNRepository repository = RepositoryConnection
					.connectTestRepository(project, user);

			new CreateTestClass(repository, entry);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

}
