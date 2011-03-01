package sourceagile.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projectDatabaseAccess")
public interface ProjectDatabaseServerCalls extends RemoteService {

	Project getProject(Long projectID);

	void saveProject(Project project);

	void updateProject(Project project);

}