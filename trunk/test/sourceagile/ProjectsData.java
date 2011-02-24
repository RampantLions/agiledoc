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
		project.setRoot("/client/scheduler/src/com/platrasha/trip/client/scheduler/client/");
		project.setTestRoot("/client/scheduler/test/com/platrasha/trip/client/scheduler/client/");
		project.setDomain("daywidget");
		project.setDescription("");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Date", "date"));
		projectComponents.add(new ProjectComponents("Editor", "editor"));
		projectComponents.add(new ProjectComponents("Events", "events"));
		projectComponents.add(new ProjectComponents("Panels", "panels"));
		projectComponents.add(new ProjectComponents("Table", "table"));
		projectComponents.add(new ProjectComponents("Utils", "utils"));

		project.setProjectComponents(projectComponents);

		return project;
	}

	private static Project loadProject4() {

		Project proj = new Project();
		// proj.setProjectID(new Long(4));
		proj.setName("Jogo Da Velha");
		proj.setProgramLanguage(Project.LOCALE_PORTUGUESE);
		proj.setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		proj.setRepositoryURL("https://tictactoe4j.googlecode.com/svn");
		proj.setRoot("/tags/Release_0.7_JogoDaVelha/src/");
		proj.setTestRoot("/tags/Release_0.7_JogoDaVelha/test/");
		proj.setDomain("jogoDaVelha");
		proj.setRelatedLinks("http://pt.wikipedia.org/wiki/Jogo_da_velha");

		proj.setDescription("O Jogo da Velha (português brasileiro) ou jogo do galo (português europeu) "
				+ "é um jogo e passatempo popular."
				+ " Um jogo de lápis e papel para dois jogadores, O e X, que se revezam marcando os espaços "
				+ " em uma grade 3x3. O jogador que conseguir colocar três respectivas marcas em uma linha horizontal,"
				+ " vertical ou diagonal, ganha o jogo.");

		List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

		projectComponents.add(new ProjectComponents("Autenticação",
				"autenticacao/client"));
		projectComponents.add(new ProjectComponents("Jogo", "client"));
		projectComponents.add(new ProjectComponents("Infra-estrutura/Servidor",
				"server"));
		projectComponents.add(new ProjectComponents(
				"Infra-estrutura/Entidades", "shared"));

		proj.setProjectComponents(projectComponents);

		return proj;
	}
}
