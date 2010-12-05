package sourceagile.documentation.client.serverCalls;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("fileExporter")
public interface FileExporterRemoteClasses extends RemoteService {

	String createFile(String fileName, String fileContent);
}