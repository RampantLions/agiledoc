package sourceagile.shared.data;

import sourceagile.shared.Project;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[2];

		projs[0] = new Project();
		projs[0].setName("Source Agile");
		projs[0].setRepositoryURL("http://agiledoc.googlecode.com");
		projs[0].setRoot("/svn/trunk/src/");
		projs[0].setDomain("sourceagile/client");

		projs[1] = new Project();
		projs[1].setName("Tic Tac Toe");
		projs[1].setRepositoryURL("http://tictactoe4j.googlecode.com");
		projs[1].setRoot("/svn/trunk/src/");
		projs[1].setDomain("tictactoe/client");

		return projs;
	}
}
