package sourceagile.client;

import helpagile.client.HelpAgileExport;
import sourceagile.authentication.client.serverCalls.ListProjects;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT Entrance (EntryPoint)
 * 
 * @Architecture
 */
public class GwtStart implements EntryPoint {

	public void onModuleLoad() {

		HelpAgileExport.initHelp("LiveSource");

		new ListProjects();
	}

}
