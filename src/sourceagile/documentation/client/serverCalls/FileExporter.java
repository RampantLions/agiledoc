package sourceagile.documentation.client.serverCalls;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FileExporter {

	private final ExportFileServerCallsAsync fileExporterRemoteFunctions = GWT
			.create(ExportFileServerCalls.class);

	public FileExporter(String fileName, String fileContent) {

		fileExporterRemoteFunctions.createFile(fileName, fileContent,
				new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {

						//Window.alert(result);
					}

					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user

					}

				});

	}

}
