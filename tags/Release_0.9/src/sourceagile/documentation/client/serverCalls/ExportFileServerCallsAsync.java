package sourceagile.documentation.client.serverCalls;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportFileServerCallsAsync {

	void createFile(String fileName, String fileContent,
			AsyncCallback<String> callback);

}
