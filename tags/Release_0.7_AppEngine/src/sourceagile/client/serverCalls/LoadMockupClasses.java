package sourceagile.client.serverCalls;

import java.util.HashMap;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class LoadMockupClasses {

	public LoadMockupClasses(final HashMap<String, ClassFile> classFiles) {

		for (ClassFile classFile : classFiles.values()) {

			RequestBuilder requestBuilder = new RequestBuilder(
					RequestBuilder.GET, "files/mockup/tictactoe/"
							+ classFile.getFileName());

			try {
				requestBuilder.sendRequest(null, new RequestCallback() {

					public void onResponseReceived(Request request,
							Response response) {

						HashMap<String, ClassFile> classFiles = ConvertRemoteClassesXML
								.getClasses(response.getText());

						ProjectInitialization.projectEntries = classFiles;

						GlobalVariables.mainPage = new MainPage();

						RootPanel.get("htmlID").clear();
						RootPanel.get("htmlID").add(GlobalVariables.mainPage);

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
