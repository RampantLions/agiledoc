package sourceagile.client.userFeatures.systemNavigation.systemMenu;

import com.google.gwt.user.client.ui.HorizontalPanel;

public class SystemMenu extends HorizontalPanel {

	public SystemMenu() {

		this.setHeight("70px");

		this.setSpacing(20);

		this.add(new ButtonPlanning());

		this.add(new ButtonFeatures());

		this.add(new ButtonSpecification());

		this.add(new ButtonSource());

		this.add(new ButtonProductivity());

		this.add(new ButtonDiagnosis());

		this.add(new ButtonWiki());
	}
}
