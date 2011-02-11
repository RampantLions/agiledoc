package sourceagile.planning.client.serverCalls;

import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @Architecture
 */
public interface ProjectBacklogServerCallsAsync {

	void addProjectBacklog(Long projectID, ProjectBacklog projectBacklog,
			AsyncCallback<Void> callback);

	void updateProjectBacklog(Long projectID, ProjectBacklog projectBacklog,
			AsyncCallback<Void> callback);

}
