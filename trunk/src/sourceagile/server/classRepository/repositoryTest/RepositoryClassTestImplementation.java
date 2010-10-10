package sourceagile.server.classRepository.repositoryTest;

import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.client.serverConnection.test.LoadRemoteTestClasses;
import sourceagile.server.classRepository.RepositoryConnection;
import sourceagile.server.classRepository.repositoryLoader.GetRepositoryClass;
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

			entry = GetRepositoryClass.getClassFile(repository, entry);

		} catch (Exception e) {

			System.out.println(e.toString());
		}

		return entry;
	}

}
