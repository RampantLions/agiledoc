package sourceagile.administration.client.project;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @Architecture
 */
public interface ProjectAdministrationServerCallsAsync {

	void saveProject(Project project, AsyncCallback<Void> callback);

}
