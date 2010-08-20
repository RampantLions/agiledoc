package com.agiledoc.client;

import com.agiledoc.shared.data.ProjectsData;
import com.agiledoc.shared.model.Project;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GlobalVariables {

	public static Project project = ProjectsData.load()[0];

	private static VerticalPanel VP_BODY = new VerticalPanel();

	public static Project getProject() {
		return project;
	}

	public static void setProject(Project project) {
		GlobalVariables.project = project;
	}

	public static VerticalPanel getVP_BODY() {
		return VP_BODY;
	}

	public static void setVP_BODY(Widget w) {
		VP_BODY.clear();
		VP_BODY.add(w);
	}

}
