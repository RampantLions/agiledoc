package sourceagile.server.fileExporter;

import java.io.File;

import sourceagile.documentation.client.export.serverCalls.ExportFileServerCalls;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class FileExporterImplementation extends RemoteServiceServlet implements
		ExportFileServerCalls {

	@Override
	public String createFile(String fileName, String fileContent) {

		File tempFile = null;

		/*
		 * try {
		 * 
		 * tempFile = new File("files/" + fileName + "_Specification.xml");
		 * 
		 * OutputStream out = new FileOutputStream(tempFile);
		 * out.write(fileContent.getBytes()); out.close();
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return tempFile.getPath();
	}

}
