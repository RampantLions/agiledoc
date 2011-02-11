package sourceagile.planning.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @Architecture
 */
public interface GetProjectServerCallsAsync {

	void getProject(Long projectID, AsyncCallback<Project> callback);

}
