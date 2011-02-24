package sourceagile.client.serverCalls;

import java.util.HashMap;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.FileNameGenerator;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public class LoadMockupClasses {

	public LoadMockupClasses(final HashMap<String, ClassFile> classFiles) {

		for (final ClassFile classFile : classFiles.values()) {

			RequestBuilder requestBuilder = new RequestBuilder(
					RequestBuilder.GET,
					"files/mockup/"
							+ FileNameGenerator
									.compactName(ProjectInitialization.currentProject
											.getName()) + "/"
							+ classFile.getFileName());

			try {
				requestBuilder.sendRequest(null, new RequestCallback() {

					public void onResponseReceived(Request request,
							Response response) {

						classFile.setSourceCode(response.getText());

						ProjectInitialization.projectEntries.put(
								classFile.toString(), classFile);

						// if (classFile.getFileName().contains(".java")) {

						// new GetClassDoclet(classFile);
						// }
					}

					public void onError(Request request, Throwable exception) {

						Window.alert("Failed to send the message: "
								+ exception.getMessage());
					}
				});

			} catch (RequestException e) {

				e.printStackTrace();
			}
		}
	}
}
