package sourceagile.client.userFeatures.project;

import java.util.ArrayList;

import sourceagile.client.serverCalls.ListClassesHistory;
import sourceagile.client.serverCalls.ListRemoteClasses;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Productivity;
import sourceagile.shared.Project;

public class ProjectInitialization {

	public static Project currentProject = new Project();

	public static ClassFile[] projectEntries;

	public static ArrayList<Productivity> projectActivity;

	public static Productivity projectTotals;

	public ProjectInitialization(Project project) {

		currentProject = project;

		projectActivity = null;

		projectTotals = null;

		new ListRemoteClasses();

		new ListClassesHistory();
	}

}
