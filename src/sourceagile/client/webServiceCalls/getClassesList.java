package sourceagile.client.webServiceCalls;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

public class getClassesList {

	public getClassesList() {

		String webServiceURL = "http://livesourceagile.com:8080/FileRepositoryWebService/rest/";

		String servicePath = "classesList/";

		String repositoryURL = "https:--tictactoe4j.googlecode.com-svn-trunk-src-tictactoe-server/";

		String username = "Alline.Oliveira/";

		String pass = "bD8Km8se2rV9/";

		String locale = "en";

		String url = webServiceURL + servicePath;

		// String url = webServiceURL + servicePath + repositoryURL + username
		// + pass + locale;
		// "http://localhost:8080/JavadocWebService/rest/classes";

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				URL.encode(url));

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onResponseReceived(Request request,
						Response response) {

					if (200 == response.getStatusCode()) {

						JsArrayString array = asArray(response.getText());

						loadProjectEntries(array);

					} else {
						// response.getStatusText()
					}
				}

				public void onError(Request request, Throwable exception) {

					System.out.print(exception);
				}
			});

		} catch (RequestException e) {
			// Couldn't connect to server }

		}

	}

	private final native JsArrayString asArray(String json) /*-{
		return eval(json);
	}-*/;

	private static void loadProjectEntries(JsArrayString array) {

		for (int i = 0; i < array.length(); i++) {

			final String name = array.get(i);

			// String entryKey = ProjectInitialization.currentProject
			// .getRepositoryURL() + "/" + classFileComponent.toString();

			// ProjectInitialization.projectEntries.put(entryKey,
			// classFileComponent);

		}
	}

}
