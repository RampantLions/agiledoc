package com.agiledoc.shared.data;

import com.agiledoc.shared.model.Project;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ProjectsData extends HorizontalPanel {

	public static Project[] load() {

		Project[] projs = new Project[2];

		projs[0] = new Project();
		projs[0].setName("AgileDoc");
		projs[0].setRoot("C:/eclipse2/workspace/AgileDoc/src");
		projs[0].setDomain("com.agiledoc");
		projs[0].setFeatureRelativePackage("client.view");

		projs[1] = new Project();
		projs[1].setName("PALMS");
		projs[1].setRoot("C:/eclipse/workspace/PALMS_Browser/src");
		projs[1].setDomain("org.paceproject.palms.browser");
		projs[1].setFeatureRelativePackage("client.view");

		return projs;
	}
}
