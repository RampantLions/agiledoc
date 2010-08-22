package agiledoc.client;

import agiledoc.client.navigation.MainPage;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class SystemInitialization implements EntryPoint {

	MainPage mainPage = new MainPage();

	public void onModuleLoad() {

		ShowMainPage();
	}

	private void ShowMainPage() {	

		RootPanel.get().add(mainPage);
	}

}
