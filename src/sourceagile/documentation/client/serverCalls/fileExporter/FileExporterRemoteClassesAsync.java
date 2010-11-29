package sourceagile.documentation.client.serverCalls.fileExporter;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FileExporterRemoteClassesAsync {

	void createFile(String fileName, String fileContent,
			AsyncCallback<String> callback);

}
