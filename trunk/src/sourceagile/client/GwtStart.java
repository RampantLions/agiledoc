package sourceagile.client;

import helpagile.client.HelpInitialization;
import sourceagile.authentication.client.serverCalls.ListProjects;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT Entrance (EntryPoint)
 * 
 * @Architecture
 */
public class GwtStart implements EntryPoint {

	public void onModuleLoad() {

		GlobalVariables.locale = com.google.gwt.user.client.Window.Location
				.getParameter("locale");

		HelpInitialization.initHelp("LiveSource");

		new ListProjects();
	}

}
