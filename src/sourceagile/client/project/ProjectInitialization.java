package sourceagile.client.project;

import java.util.ArrayList;

import sourceagile.client.productivity.Procuctivity;
import sourceagile.client.serverConnection.ListRemoteClasses;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Project;

public class ProjectInitialization {

	public static Project currentProject = new Project();

	public static ClassFile[] projectEntries;

	public static ArrayList<Procuctivity> projectActivity;

	public static Procuctivity projectTotals;

	public ProjectInitialization(Project project) {

		currentProject = project;

		projectActivity = null;

		projectTotals = null;

		new ListRemoteClasses();
	}

}
