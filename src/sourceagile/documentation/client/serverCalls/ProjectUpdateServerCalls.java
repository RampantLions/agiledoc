package sourceagile.documentation.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("projectDatabaseAccess")
public interface ProjectUpdateServerCalls extends RemoteService {

	void updateProject(Project project);

}