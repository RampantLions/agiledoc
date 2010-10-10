package sourceagile.shared.data;

import sourceagile.shared.Project;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[3];

		projs[0] = new Project();
		projs[0].setName("Source Agile Client Side");
		projs[0].setRepositoryURL("https://agiledoc.googlecode.com/svn");
		projs[0].setRoot("/trunk/src/");
		projs[0].setTestRoot("/trunk/test/");
		projs[0].setDomain("sourceagile/client");
		projs[0].setSpecificationPath("userFeatures");

		projs[1] = new Project();
		projs[1].setName("Source Agile Server Side");
		projs[1].setRepositoryURL("https://agiledoc.googlecode.com/svn");
		projs[1].setRoot("/trunk/src/");
		projs[1].setTestRoot("/trunk/test/");
		projs[1].setDomain("sourceagile/server");

		projs[2] = new Project();
		projs[2].setName("Tic Tac Toe");
		projs[2].setRepositoryURL("https://tictactoe4j.googlecode.com/svn");
		projs[2].setRoot("/trunk/src/");
		projs[2].setTestRoot("/trunk/test/");
		projs[2].setDomain("tictactoe/client");
		projs[2].setSpecificationPath("userFeatures");
		// projs[2].setWiki("http://");

		return projs;
	}
}
