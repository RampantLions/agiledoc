package sourceagile.client.systemNavigation;

import sourceagile.client.SystemStart;
import sourceagile.client.systemNavigation.projectMenu.ProjectMenu;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPage extends VerticalPanel {

	public HorizontalPanel panelMenus = new HorizontalPanel();

	public VerticalPanel panelContent = new VerticalPanel();

	public MainPage() {

		setSize("100%", "100%");

		addUserName();

		addTopMenus();

		addContentsPanel();
	}

	private void addUserName() {

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HTML userName = new HTML("<font size=1 color=blue>"
				+ SystemStart.currentUser.getName() + "</font>");
		userName.setAutoHorizontalAlignment(ALIGN_LEFT);
		userName.setWidth("200px");

		this.add(userName);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
	}

	private void addTopMenus() {

		panelMenus.setWidth("1200px");

		panelMenus.add(new ProjectName());

		panelMenus.add(new ProjectMenu());

		panelMenus.add(new SystemOptions());

		this.add(panelMenus);
	}

	private void addContentsPanel() {

		panelContent.setSize("100%", "100%");

		panelContent.setSpacing(20);

		panelContent.add(new WelcomePage());

		this.add(panelContent);
	}
}
