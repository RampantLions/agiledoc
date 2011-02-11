package sourceagile.planning.client.serverCalls;

import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @Architecture
 */
@RemoteServiceRelativePath("projectDatabaseAccess")
public interface ProjectBacklogServerCalls extends RemoteService {

	void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog);

}