package sourceagile.documentation.client.serverCalls;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProjectUpdateServerCallsAsync {

	void updateProject(Project project, AsyncCallback<Void> callback);

}
