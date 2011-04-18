package sourceagile.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @Architecture
 */
@RemoteServiceRelativePath("projectDatabaseAccess")
public interface ProjectDatabaseServerCalls extends RemoteService {

	List<Project> listProjects();

	Project getProject(Long projectID);

	void saveProject(Project project);

	void updateProject(Project project);

}