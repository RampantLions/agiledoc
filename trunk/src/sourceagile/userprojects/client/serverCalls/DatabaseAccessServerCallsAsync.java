package sourceagile.userprojects.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.Comments;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @architecture
 */
public interface DatabaseAccessServerCallsAsync {

	void listProjects(AsyncCallback<List<Project>> callback);

	void getProject(Long projectID, AsyncCallback<Project> callback);

	void saveProject(Project project, AsyncCallback<Void> callback);

	void saveProjectBacklog(Long projectID, ProjectBacklog projectBacklog,
			AsyncCallback<Void> callback);

	void listComments(Long projectID, String classPath,
			AsyncCallback<List<Comments>> callback);

	void saveComment(Comments comment, AsyncCallback<Void> callback);

}
