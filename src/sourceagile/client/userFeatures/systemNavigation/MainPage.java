package sourceagile.client.userFeatures.systemNavigation;

import sourceagile.client.userFeatures.project.ProjectMenu;
import sourceagile.client.userFeatures.project.ProjectName;
import sourceagile.client.userFeatures.systemNavigation.systemMenu.SystemMenu;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPage extends VerticalPanel {

	public HorizontalPanel panelMenus = new HorizontalPanel();

	public VerticalPanel panelContent = new VerticalPanel();

	public MainPage() {

		setSize("100%", "100%");

		addTopMenus();

		addContentsPanel();
	}

	private void addTopMenus() {

		panelMenus.setWidth("1200px");

		panelMenus.add(new ProjectName());

		panelMenus.add(new SystemMenu());

		panelMenus.add(new ProjectMenu());

		this.add(panelMenus);
	}

	private void addContentsPanel() {

		panelContent.setSize("100%", "100%");

		panelContent.setSpacing(20);

		panelContent.add(new WelcomePage());

		this.add(panelContent);
	}
}
