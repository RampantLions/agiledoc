package agiledoc.client;

import agiledoc.client.navigation.MainPage;
import agiledoc.shared.Project;
import agiledoc.shared.User;
import agiledoc.shared.data.ProjectsData;
import agiledoc.shared.data.UserData;

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
