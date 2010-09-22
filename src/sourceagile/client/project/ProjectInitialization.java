package sourceagile.client.project;

import java.util.ArrayList;

import sourceagile.client.activity.Activity;
import sourceagile.client.serverConnection.ListRemoteClasses;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;

public class ProjectInitialization {

	public static Project currentProject = new Project();

	public static ClassFile[] projectEntries;

	public static ArrayList<Activity> projectActivity;

	public static Activity projectTotals;

	public ProjectInitialization(Project project) {

		currentProject = project;

		projectActivity = null;

		projectTotals = null;

		new ListRemoteClasses();
	}

}
