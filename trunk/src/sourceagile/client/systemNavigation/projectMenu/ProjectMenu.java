package sourceagile.client.systemNavigation.projectMenu;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ProjectMenu extends HorizontalPanel {

	public ProjectMenu() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.setWidth("350px");

		this.add(new ButtonPlanning());

		this.add(new ButtonDevelopment());

		this.add(new ButtonDocumentation());

		this.add(new ButtonMetrics());
	}
}
