package sourceagile.server.classRepositories.subversionClassRepository;

import java.util.ArrayList;
import java.util.HashMap;

import sourceagile.client.serverCalls.LoadRemoteClasses;
import sourceagile.server.classRepositories.subversionFileRepository.EditFile;
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
	public HashMap<String, ClassFile> listClasses(Project project, User user) {

		return ListFiles.listClasses(project, user);
	}

	@Override
	public ClassFile getClass(Project project, User user, ClassFile entry) {

		return GetClass.getClass(project, user, entry);
	}

	@Override
	public void createClass(Project project, User user, ClassFile classFile,
			String newSubfolderName) {

		new AddTodoClass(project, user, classFile, newSubfolderName);
	}

	@Override
	public void editClass(Project project, User user, ClassFile classFile,
			String classDescription) {

		new EditClassDescription(project, user, classFile, classDescription);
	}

	@Override
	public void editSourceCode(Project project, User user, ClassFile classFile) {

		EditFile.update(project.getRepositoryURL(), user.getName(),
				user.getPassword(), classFile.getFilePath(),
				classFile.getFileName(), classFile.getSourceCode());

	}

	@Override
	public ArrayList<Productivity> listHistory(Project project, User user) {

		return ListHistory.getRemoteClasses(project, user);
	}

}
