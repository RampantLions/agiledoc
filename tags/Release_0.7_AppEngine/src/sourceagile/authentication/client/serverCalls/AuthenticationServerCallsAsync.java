package sourceagile.authentication.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @architecture
 */
public interface AuthenticationServerCallsAsync {

	void listProjects(AsyncCallback<List<Project>> callback);

	void getProject(Long projectID, AsyncCallback<Project> callback);

}
