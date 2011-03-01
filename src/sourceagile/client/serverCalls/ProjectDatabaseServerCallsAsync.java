package sourceagile.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProjectDatabaseServerCallsAsync {

	void getProject(Long projectID, AsyncCallback<Project> callback);

	void saveProject(Project project, AsyncCallback<Void> callback);

	void updateProject(Project project, AsyncCallback<Void> callback);

}
