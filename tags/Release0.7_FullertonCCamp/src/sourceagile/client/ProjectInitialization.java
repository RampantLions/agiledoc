package sourceagile.client;

import java.util.ArrayList;

import sourceagile.client.serverCalls.ListClassesHistory;
import sourceagile.client.serverCalls.ListRemoteClasses;
import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.Project;

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
