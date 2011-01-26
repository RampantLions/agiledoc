package sourceagile.client;

import helpagile.client.HelpAgileExport;
import sourceagile.authentication.client.serverCalls.ListLoginProjects;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.entities.User;

import com.google.gwt.core.client.EntryPoint;

/**
 * Show the first page of the system.
 * 
 */
public class SystemStart implements EntryPoint {

	public static MainPage mainPage;

	public static String systemVersion = "Prototype Version 0.6";

	public static User currentUser = new User();

	public void onModuleLoad() {

		HelpAgileExport.initHelp("SourceAgile");

		new ListLoginProjects();
	}

}
