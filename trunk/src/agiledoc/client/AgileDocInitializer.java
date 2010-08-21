package agiledoc.client;

import agiledoc.client.navigation.MainPage;
import agiledoc.client.navigation.systemMenu.SystemMenu;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class AgileDocInitializer implements EntryPoint {

	MainPage mainPage = new MainPage();

	public void onModuleLoad() {

		ShowMainPage();

		ShowSystemMenu();

		// Start Feature Tree Page

		// Show Feature Tree

	}

	private void ShowMainPage() {

		RootPanel.get().add(mainPage);
	}

	private void ShowSystemMenu() {

		mainPage.add(new SystemMenu());
	}
}
