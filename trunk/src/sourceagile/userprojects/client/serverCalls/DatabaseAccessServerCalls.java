package sourceagile.userprojects.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/** 
 * 
 * 
 * @architecture 
 */

@RemoteServiceRelativePath("databaseAccess")
public interface DatabaseAccessServerCalls extends RemoteService {

	List<Project> listProjects();

	Project getProject(Long projectID);

	void saveProject(Project project);

	void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog);

}