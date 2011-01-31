package sourceagile.client;

import helpagile.client.HelpAgileExport;
import sourceagile.authentication.client.serverCalls.ListProjects;

import com.google.gwt.core.client.EntryPoint;

/**
 * Anchor class to init the system by the Google Web Toolkit (EntryPoint).
 * 
 * @Architecture
 */
public class GwtStart implements EntryPoint {

	public void onModuleLoad() {

		HelpAgileExport.initHelp("SourceAgile");

		new ListProjects();
	}

}
