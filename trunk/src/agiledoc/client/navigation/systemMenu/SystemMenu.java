package agiledoc.client.navigation.systemMenu;

import com.google.gwt.user.client.ui.HorizontalPanel;

public class SystemMenu extends HorizontalPanel {

	public SystemMenu() {

		setSpacing(20);

		add(new ButtonPlanning());

		add(new ButtonFeatures());

		add(new ButtonActivity());
	}
}
