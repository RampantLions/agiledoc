package sourceagile.client.project;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @Architecture
 */
public interface ProjectDatabaseServerCallsAsync {

	void listProjects(AsyncCallback<List<Project>> callback);

	void getProject(Long projectID, AsyncCallback<Project> callback);

	void saveProject(Project project, AsyncCallback<Void> callback);

	void updateProject(Project project, AsyncCallback<Void> callback);

}
