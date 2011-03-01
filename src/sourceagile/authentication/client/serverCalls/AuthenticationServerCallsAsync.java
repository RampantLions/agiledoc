package sourceagile.authentication.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthenticationServerCallsAsync {

	void getProject(Long projectID, AsyncCallback<Project> callback);

	void listProjects(String locale, AsyncCallback<List<Project>> callback);

}
