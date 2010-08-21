package agiledoc.client.navigation;

import agiledoc.client.navigation.systemMenu.SystemMenu;

import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPage extends VerticalPanel {

	public static VerticalPanel panelContent = new VerticalPanel();

	public MainPage() {

		setSize("100%", "100%");

		panelContent.setSize("100%", "100%");

		panelContent.setSpacing(20);

		ShowSystemMenu();

		this.add(panelContent);

		ShowWelcomePage();
	}

	private void ShowSystemMenu() {

		this.add(new SystemMenu());
	}

	private void ShowWelcomePage() {

		panelContent.add(new WelcomePage());
	}
}
