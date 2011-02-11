package sourceagile;

import java.util.ArrayList;
import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectComponents;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[3];

		// loadProject0(projs);
		// loadProject1(projs);
		// loadProject2(projs);

		return projs;
	}

	public static Project loadProject0() {

		Project project = new Project();
		// project.setProjectID(new Long(1));
		project.setName("Source Agile");
		project.setRepositoryType(sourceagile.shared.entities.project.Project.REPOSITORY_TYPE_SUBVERSION);
		project.setRepositoryURL("https://agiledoc.googlecode.com/svn");
		project.setRoot("/trunk/src/");
		project.setTestRoot("/trunk/test/");
		project.setDomain("sourceagile");
		project.setRelatedLinks("http://code.google.com/p/agiledoc/wiki/SourceAgile");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Authentication",
				"authentication/client"));
		projectComponents.add(new ProjectComponents("System Navigation",
				"client/systemNavigation"));
		projectComponents.add(new ProjectComponents("Planning",
				"planning/client"));
		projectComponents.add(new ProjectComponents("Development",
				"development/client"));
		projectComponents.add(new ProjectComponents("Documentation",
				"documentation/client"));

		projectComponents
				.add(new ProjectComponents("Testing", "testing/client"));
		projectComponents.add(new ProjectComponents("Code Visualization",
				"codeview/client"));
		projectComponents
				.add(new ProjectComponents("Metrics", "metrics/client"));

		projectComponents.add(new ProjectComponents(
				"Infra Structure/Class Repositories",
				"server/classRepositories"));
		projectComponents.add(new ProjectComponents(
				"Infra Structure/Database Access", "server/databaseAccess"));
		projectComponents.add(new ProjectComponents("Infra Structure/Doclet",
				"server/doclet"));

		projectComponents.add(new ProjectComponents("Entities",
				"shared/entities"));

		project.setProjectComponents(projectComponents);

		return project;
	}

	public static Project loadProject1() {

		Project project = new Project();
		// project.setProjectID(new Long(2));
		project.setName("Tic Tac Toe");
		project.setRepositoryType(sourceagile.shared.entities.project.Project.REPOSITORY_TYPE_SUBVERSION);
		project.setRepositoryURL("https://tictactoe4j.googlecode.com/svn");
		project.setRoot("/trunk/src/");
		project.setTestRoot("/trunk/test/");
		project.setDomain("tictactoe");
		project.setRelatedLinks("http://en.wikipedia.org/wiki/Tic-tac-toe");
		project.setDescription("Tic-tac-toe, also spelled tick tack toe, or noughts and crosses as it is known in the UK, Ireland, "
				+ "Australia, New Zealand, is a pencil-and-paper game for two players, O and X, who take turns marking the spaces in a 3x3 grid,"
				+ " usually X going first. The player who succeeds in placing three respective marks in a horizontal, vertical, or diagonal row wins the game.");

		project.setRelatedLinks("Tic Tac Toe online version:"
				+ "(Google App Engine): http://tictactoe4j.appspot.com"
				+ "What is Tic Tac Toe: "
				+ "http://en.wikipedia.org/wiki/Tic-tac-toe"
				+ "tictactoe4j  -  File Repository:"
				+ "Google Code - Subversion:"
				+ "# Non-members may check out a read-only working copy anonymously over HTTP."
				+ "svn checkout http://tictactoe4j.googlecode.com/svn/trunk/ tictactoe4j-read-only");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Authentication",
				"authentication/client"));
		projectComponents.add(new ProjectComponents("Gaming", "client"));
		projectComponents.add(new ProjectComponents("Infra Structure/Server",
				"server"));
		projectComponents.add(new ProjectComponents("Infra Structure/Entities",
				"shared"));

		project.setProjectComponents(projectComponents);

		return project;

	}

	public static Project loadProject2() {

		Project project = new Project();
		// project.setProjectID(new Long(3));
		project.setName("Help Agile");
		project.setRepositoryType(sourceagile.shared.entities.project.Project.REPOSITORY_TYPE_SUBVERSION);
		project.setRepositoryURL("https://agilehelp.googlecode.com/svn");
		project.setRoot("/trunk/src/");
		project.setTestRoot("/trunk/test/");
		project.setDomain("helpagile");
		project.setDescription("Help Agile is an automatic generated specification "
				+ "and user documentation for your software.");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Help Agile", "client"));

		project.setProjectComponents(projectComponents);

		return project;
	}

	public static Project loadProject3() {

		Project project = new Project();
		// project.setProjectID(new Long(3));
		project.setName("Where is URL?");
		project.setRepositoryType(sourceagile.shared.entities.project.Project.REPOSITORY_TYPE_SUBVERSION);
		project.setRepositoryURL("http://platrasha.svnrepository.com/svn/code");
		project.setRoot("/client/scheduler/src/");
		project.setTestRoot("/client/scheduler/test/");
		project.setDomain("com/platrasha/trip");
		project.setDescription("");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Client", "client"));

		project.setProjectComponents(projectComponents);

		return project;
	}

}
