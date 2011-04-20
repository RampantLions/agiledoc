package sourceagile.client.systemNavigation;

import sourceagile.client.systemNavigation.projectMenu.ProjectMenu;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPage extends VerticalPanel {

	public HorizontalPanel panelMenus = new HorizontalPanel();

	public VerticalPanel panelContent = new VerticalPanel();

	public MainPage() {

		setSize("100%", "100%");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		this.add(new UserLogout());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		addTopMenus();

		addContentsPanel();
	}

	private void addTopMenus() {

		panelMenus.setWidth("1200px");

		panelMenus.add(new ProjectName());

		panelMenus.add(new ProjectMenu());

		panelMenus.add(new SystemTopOptions());

		this.add(panelMenus);
	}

	private void addContentsPanel() {

		panelContent.setSize("100%", "100%");

		panelContent.setSpacing(20);

		panelContent.add(new WelcomePage());

		this.add(panelContent);
	}
}
