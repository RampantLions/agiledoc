package sourceagile.client;

import helpagile.client.HelpInitialization;
import sourceagile.authentication.client.serverCalls.ListProjects;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT Entrance (EntryPoint)
 * 
 * @Architecture
 */
public class GwtStart implements EntryPoint {

	public void onModuleLoad() {

		String locale = com.google.gwt.user.client.Window.Location
				.getParameter("locale");

		if (locale == null) {

			locale = Project.LOCALE_ENGLISH;
		}

		GlobalVariables.locale = locale;

		HelpInitialization.initHelp("LiveSource");

		String projectLocale = GlobalVariables.locale;
		if (Project.LOCALE_SPANISH.equals(GlobalVariables.locale)) {

			projectLocale = Project.LOCALE_ENGLISH;
		}

		new ListProjects();
	}

}
