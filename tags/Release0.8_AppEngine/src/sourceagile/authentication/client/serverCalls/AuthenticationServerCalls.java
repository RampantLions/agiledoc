package sourceagile.authentication.client.serverCalls;

import java.util.List;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projectDatabaseAccess")
public interface AuthenticationServerCalls extends RemoteService {

	Project getProject(Long projectID);

	List<Project> listProjects(String locale);

}