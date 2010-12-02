package sourceagile.userprojects.client;

import java.util.ArrayList;
import java.util.List;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectComponents;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[3];

		loadProject0(projs);
		loadProject1(projs);
		loadProject2(projs);

		return projs;
	}

	private static void loadProject0(Project[] projs) {

		projs[0] = new Project();
		projs[0].setProjectID(new Long(1));
		projs[0].setName("Source Agile");
		projs[0].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[0].setRepositoryURL("https://agiledoc.googlecode.com/svn");
		projs[0].setRoot("/trunk/src/");
		projs[0].setTestRoot("/trunk/test/");
		projs[0].setDomain("sourceagile");
		projs[0].setSpecificationPath("client/userFeatures");
		projs[0].setWiki("http://code.google.com/p/agiledoc/wiki/SourceAgile");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Authentication",
				"authentication/client"));
		projectComponents.add(new ProjectComponents("User Projects",
				"userprojects/client"));
		projectComponents.add(new ProjectComponents("System Navigation",
				"client/systemNavigation"));
		projectComponents.add(new ProjectComponents("Planning",
				"planning/client"));
		projectComponents.add(new ProjectComponents("Documentation",
				"documentation/client"));

		projectComponents
				.add(new ProjectComponents("Testing", "testing/client"));
		projectComponents.add(new ProjectComponents("Code Visualization",
				"codeview/client"));
		projectComponents
				.add(new ProjectComponents("Metrics", "metrics/client"));

		projectComponents.add(new ProjectComponents(
				"Server Side/Class Repositories", "server/classRepositories"));
		projectComponents.add(new ProjectComponents(
				"Server Side/Database Access", "server/databaseAccess"));
		projectComponents.add(new ProjectComponents("Server Side/Doclet",
				"server/doclet"));

		projectComponents.add(new ProjectComponents("Entities",
				"shared/entities"));

		projs[0].setProjectComponents(projectComponents);
	}

	private static void loadProject1(Project[] projs) {

		projs[1] = new Project();
		projs[1].setProjectID(new Long(2));
		projs[1].setName("Tic Tac Toe");
		projs[1].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[1].setRepositoryURL("https://tictactoe4j.googlecode.com/svn");
		projs[1].setRoot("/trunk/src/");
		projs[1].setTestRoot("/trunk/test/");
		projs[1].setDomain("tictactoe");
		projs[1].setSpecificationPath("client/userInterface");
		projs[1].setWiki("http://en.wikipedia.org/wiki/Tic-tac-toe");

		projs[1].setDescription("Tic-tac-toe, also spelled tick tack toe, or noughts and crosses as it is known in the UK, Ireland, "
				+ "Australia, New Zealand, is a pencil-and-paper game for two players, O and X, who take turns marking the spaces in a 3x3 grid,"
				+ " usually X going first. The player who succeeds in placing three respective marks in a horizontal, vertical, or diagonal row wins the game.");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Authentication",
				"authentication/client"));
		projectComponents.add(new ProjectComponents("Gaming", "client"));
		projectComponents
				.add(new ProjectComponents("Infra Structure", "server"));

		projs[1].setProjectComponents(projectComponents);

	}

	private static void loadProject2(Project[] projs) {

		projs[2] = new Project();
		projs[2].setProjectID(new Long(3));
		projs[2].setName("Help Agile");
		projs[2].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[2].setRepositoryURL("https://agilehelp.googlecode.com/svn");
		projs[2].setRoot("/trunk/src/");
		projs[2].setTestRoot("/trunk/test/");
		projs[2].setDomain("helpagile");
		projs[2].setSpecificationPath("client/userInterface");

		projs[2].setDescription("Help Agile is an automatic generated specification "
				+ "and user documentation for your software.");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Help Agile", "client"));

		projs[2].setProjectComponents(projectComponents);

	}

}
