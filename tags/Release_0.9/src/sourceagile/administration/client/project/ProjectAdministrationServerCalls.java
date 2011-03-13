package sourceagile.administration.client.project;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @Architecture
 */
@RemoteServiceRelativePath("projectDatabaseAccess")
public interface ProjectAdministrationServerCalls extends RemoteService {

	void saveProject(Project project);

}