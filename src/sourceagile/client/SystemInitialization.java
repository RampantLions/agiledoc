package sourceagile.client;

import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.Project;
import sourceagile.shared.User;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.data.UserData;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class SystemInitialization implements EntryPoint {

	public static MainPage mainPage = new MainPage();

	public static Project currentProject = new Project();

	public static User currentUser = new User();

	public void onModuleLoad() {

		RootPanel.get().add(mainPage);

		currentProject = ProjectsData.load()[0];

		currentUser = UserData.load()[0];
	}

}
