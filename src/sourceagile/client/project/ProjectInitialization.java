package sourceagile.client.project;

import sourceagile.client.serverConnection.ListRemoteClasses;
import sourceagile.shared.Entry;
import sourceagile.shared.Project;

public class ProjectInitialization {

	public static Project currentProject = new Project();

	public static Entry[] projectEntries;

	public ProjectInitialization(Project project) {

		currentProject = project;

		new ListRemoteClasses();
	}

}
