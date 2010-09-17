package sourceagile.client.project;

import java.util.ArrayList;

import sourceagile.client.activity.Activity;
import sourceagile.client.serverConnection.ListRemoteClasses;
import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.shared.Entry;
import sourceagile.shared.Project;

import com.google.gwt.user.client.ui.RootPanel;

public class ProjectInitialization {

	public static Project currentProject = new Project();

	public static Entry[] projectEntries;

	public static ArrayList<Activity> projectActivity;

	public ProjectInitialization(Project project) {

		RootPanel.get().clear();
		RootPanel.get().add(new LoadingPanel());

		currentProject = project;

		new ListRemoteClasses();
	}

}
