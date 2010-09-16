package sourceagile.client;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.User;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.data.UserData;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class SystemInitialization implements EntryPoint {

	public static MainPage mainPage = new MainPage();

	public static User currentUser = new User();

	public void onModuleLoad() {

		RootPanel.get().clear();
		RootPanel.get().add(new LoadingPanel());

		currentUser = UserData.load()[0];

		new ProjectInitialization(ProjectsData.load()[0]);
	}

}
