package sourceagile.server.databaseAccess;

import java.util.List;

import sourceagile.server.databaseAccess.Project.ListProjects;
import sourceagile.shared.entities.project.Project;
import sourceagile.userprojects.client.serverCalls.DatabaseAccessServerCalls;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DatabaseAccessImplementation extends RemoteServiceServlet
		implements DatabaseAccessServerCalls {

	@Override
	public List<Project> listProjects() {

		List<Project> projects = null;

		projects = ListProjects.list();

		return projects;
	}

}
