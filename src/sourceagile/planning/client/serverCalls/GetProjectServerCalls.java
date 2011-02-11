package sourceagile.planning.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * 
 * @Architecture
 */
@RemoteServiceRelativePath("projectDatabaseAccess")
public interface GetProjectServerCalls extends RemoteService {

	Project getProject(Long projectID);

}