package sourceagile.planning.client.serverCalls;

import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @Architecture
 */
@RemoteServiceRelativePath("projectBacklogDatabaseAccess")
public interface ProjectBacklogServerCalls extends RemoteService {

	void addProjectBacklog(Long projectID, ProjectBacklog projectBacklog);

	void updateProjectBacklog(Long projectID, ProjectBacklog projectBacklog);

}