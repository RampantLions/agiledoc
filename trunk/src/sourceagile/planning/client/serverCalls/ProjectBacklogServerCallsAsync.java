package sourceagile.planning.client.serverCalls;

import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @Architecture
 */
public interface ProjectBacklogServerCallsAsync {

	void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog,
			AsyncCallback<Void> callback);

}
