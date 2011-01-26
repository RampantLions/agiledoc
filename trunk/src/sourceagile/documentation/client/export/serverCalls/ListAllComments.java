package sourceagile.documentation.client.export.serverCalls;

import java.util.HashMap;

import sourceagile.client.ProjectInitialization;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.export.ExportXML;
import sourceagile.shared.entities.Comments;
import sourceagile.shared.utilities.FileNameGenerator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListAllComments {

	final AllCommentsServerCallsAsync commentsServerCalls = GWT
			.create(AllCommentsServerCalls.class);

	public ListAllComments() {

		commentsServerCalls.listAllComments(
				ProjectInitialization.currentProject.getProjectID(),
				new AsyncCallback<HashMap<String, Comments>>() {

					public void onSuccess(HashMap<String, Comments> comments) {

						Documentation.documentationPanel.clear();

						String fileContent = ExportXML.getEntriesXML(comments);

						if (fileContent.length() < 100000) {

							Documentation.documentationPanel.add(ExportXML
									.getSyntaxPanel(fileContent,
											"Specification XML format"));
						}

						String projectName = FileNameGenerator
								.compactName(ProjectInitialization.currentProject
										.getName());

						new FileExporter(projectName, fileContent);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});
	}
}
