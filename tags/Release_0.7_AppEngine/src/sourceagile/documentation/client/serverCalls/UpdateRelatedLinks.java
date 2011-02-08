package sourceagile.documentation.client.serverCalls;

import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.project.RelatedLinks;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class UpdateRelatedLinks {

	public UpdateRelatedLinks(Project project) {

		final ProjectUpdateServerCallsAsync databaseServerCalls = GWT
				.create(ProjectUpdateServerCalls.class);

		databaseServerCalls.updateProject(project, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new RelatedLinks());
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
