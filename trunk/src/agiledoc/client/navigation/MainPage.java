package agiledoc.client.navigation;

import agiledoc.client.navigation.systemMenu.SystemMenu;

import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPage extends VerticalPanel {

	public static VerticalPanel panelSystemContent = new VerticalPanel();

	public MainPage() {

		setSize("100%", "100%");

		ShowSystemMenu();

		this.add(panelSystemContent);
		
		ShowWelcomePage();
	}

	private void ShowSystemMenu() {

		this.add(new SystemMenu());
	}
	
	private void ShowWelcomePage() {

		panelSystemContent.add(new WelcomePage());
	}
}
