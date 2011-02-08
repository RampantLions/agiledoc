package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.ArrayList;
import java.util.HashMap;

import sourceagile.client.serverCalls.LoadRemoteClasses;
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
	public ClassFile getClass(Project project, User user, ClassFile entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, ClassFile> listClasses(Project project, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName) {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, ClassFile> listComponentClasses(Project project,
			User user, String componentPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Productivity> listHistory(Project project, User user) {

		return new ArrayList<Productivity>();
	}

	@Override
	public void editClass(Project project, User user, ClassFile classFile,
			String classDescription) {
		// TODO Auto-generated method stub

	}

}
