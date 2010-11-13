package sourceagile.shared.data;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectComponents;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[4];

		loadProject0(projs);
		loadProject1(projs);
		loadProject2(projs);
		loadProject3(projs);

		return projs;
	}

	private static void loadProject0(Project[] projs) {

		projs[0] = new Project();
		projs[0].setName("Source Agile");
		projs[0].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[0].setRepositoryURL("https://agiledoc.googlecode.com/svn");
		projs[0].setRoot("/trunk/src/");
		projs[0].setTestRoot("/trunk/test/");
		projs[0].setDomain("sourceagile");
		projs[0].setSpecificationPath("client/userFeatures");
		projs[0].setWiki("http://code.google.com/p/agiledoc/wiki/SourceAgile");

		ProjectComponents[] projectComponents = new ProjectComponents[12];

		projectComponents[0] = new ProjectComponents("Authentication",
				"authentication/client");
		projectComponents[1] = new ProjectComponents("User Projects",
				"userprojects/client");
		projectComponents[2] = new ProjectComponents("System Navigation",
				"client/systemNavigation");
		projectComponents[3] = new ProjectComponents("Planning",
				"planning/client");
		projectComponents[4] = new ProjectComponents("Documentation",
				"documentation/client");

		projectComponents[5] = new ProjectComponents("Testing",
				"testing/client");
		projectComponents[6] = new ProjectComponents("Code Visualization",
				"codeview/client");
		projectComponents[7] = new ProjectComponents("Metrics",
				"metrics/client");
		// projectComponents[8] = new ProjectComponents("Server Side",
		// "server");
		projectComponents[8] = new ProjectComponents(
				"Server Side/Class Repositories", "server.classRepositories");
		projectComponents[9] = new ProjectComponents(
				"Server Side/Database Access", "server.databaseAccess");
		projectComponents[10] = new ProjectComponents("Server Side/Doclet",
				"server.doclet");

		projectComponents[11] = new ProjectComponents("Entities",
				"shared/entities");

		projs[0].setProjectComponents(projectComponents);
	}

	private static void loadProject1(Project[] projs) {

		projs[1] = new Project();
		projs[1].setName("Tic Tac Toe");
		projs[1].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[1].setRepositoryURL("https://tictactoe4j.googlecode.com/svn");
		projs[1].setRoot("/trunk/src/");
		projs[1].setTestRoot("/trunk/test/");
		projs[1].setDomain("tictactoe");
		projs[1].setSpecificationPath("client/userInterface");
		projs[1].setWiki("http://en.wikipedia.org/wiki/Tic-tac-toe");

		ProjectComponents[] projectComponents = new ProjectComponents[3];

		projectComponents[0] = new ProjectComponents("Authentication",
				"authentication/client");
		projectComponents[1] = new ProjectComponents("Game Client", "client");
		projectComponents[2] = new ProjectComponents("Server Side", "server");

		projs[1].setProjectComponents(projectComponents);

	}

	private static void loadProject2(Project[] projs) {

		projs[2] = new Project();
		projs[2].setName("JDK Tools.jar");
		projs[2].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[2].setRepositoryURL("http://javatoolssource.googlecode.com/svn");
		projs[2].setRoot("/trunk/src/");

		ProjectComponents[] projectComponents = new ProjectComponents[1];

		projectComponents[0] = new ProjectComponents("", "");

		projs[2].setProjectComponents(projectComponents);

	}

	private static void loadProject3(Project[] projs) {

		projs[3] = new Project();
		projs[3].setName("Agile Help");
		projs[3].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[3].setRepositoryURL("https://agilehelp.googlecode.com/svn");
		projs[3].setRoot("/trunk/src/");
		projs[3].setTestRoot("/trunk/test/");
		projs[3].setDomain("helpagile");
		projs[3].setSpecificationPath("client/userInterface");

		ProjectComponents[] projectComponents = new ProjectComponents[1];

		projectComponents[0] = new ProjectComponents("Help Agile", "client");

		projs[3].setProjectComponents(projectComponents);

	}

}
