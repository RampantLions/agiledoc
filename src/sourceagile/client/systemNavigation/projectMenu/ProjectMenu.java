package sourceagile.client.systemNavigation.projectMenu;

import com.google.gwt.user.client.ui.HorizontalPanel;

public class ProjectMenu extends HorizontalPanel {

	public ProjectMenu() {

		this.setHeight("70px");

		this.setSpacing(20);

		this.add(new ButtonPlanning());

		this.add(new ButtonDocumentation());

		this.add(new ButtonSource());

		this.add(new ButtonProductivity());

		this.add(new ButtonDiagnosis());
	}
}
