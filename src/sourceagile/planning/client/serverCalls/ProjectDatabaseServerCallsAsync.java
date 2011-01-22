package sourceagile.planning.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.Comments;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @architecture
 */
public interface ProjectDatabaseServerCallsAsync {

	void listProjects(AsyncCallback<List<Project>> callback);

	void getProject(Long projectID, AsyncCallback<Project> callback);

	void saveProject(Project project, AsyncCallback<Void> callback);

	void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog,
			AsyncCallback<Void> callback);

}
