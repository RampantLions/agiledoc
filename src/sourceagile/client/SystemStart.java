package sourceagile.client;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.User;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.data.UserData;

import com.google.gwt.core.client.EntryPoint;

/**
 * Show the first page of the system.
 * 
 */
public class SystemStart implements EntryPoint {

	public static MainPage mainPage;

	public static User currentUser = new User();

	public void onModuleLoad() {

		currentUser = UserData.load()[0];

		new ProjectInitialization(ProjectsData.load()[2]);
	}

}
