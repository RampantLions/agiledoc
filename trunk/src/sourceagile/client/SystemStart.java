package sourceagile.client;

import sourceagile.client.authentication.Login;
import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.User;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Show the first page of the system.
 * 
 */
public class SystemStart implements EntryPoint {

	public static MainPage mainPage;

	public static User currentUser = new User();

	public void onModuleLoad() {

		RootPanel.get().clear();
		RootPanel.get().add(new Login());
	}

}
