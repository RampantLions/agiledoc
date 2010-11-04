package sourceagile.shared.data;

import sourceagile.shared.Project;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[5];

		projs[0] = new Project();
		projs[0].setName("Source Agile Client Side");
		projs[0].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[0].setRepositoryURL("https://agiledoc.googlecode.com/svn");
		projs[0].setRoot("/trunk/src/");
		projs[0].setTestRoot("/trunk/test/");
		projs[0].setDomain("sourceagile/client");
		projs[0].setSpecificationPath("userFeatures");
		projs[0].setWiki("http://code.google.com/p/agiledoc/wiki/SourceAgile");

		projs[1] = new Project();
		projs[1].setName("Source Agile Server Side");
		projs[1].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[1].setRepositoryURL("https://agiledoc.googlecode.com/svn");
		projs[1].setRoot("/trunk/src/");
		projs[1].setTestRoot("/trunk/test/");
		projs[1].setDomain("sourceagile/server");

		projs[2] = new Project();
		projs[2].setName("Tic Tac Toe");
		projs[2].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[2].setRepositoryURL("https://tictactoe4j.googlecode.com/svn");
		projs[2].setRoot("/trunk/src/");
		projs[2].setTestRoot("/trunk/test/");
		projs[2].setDomain("tictactoe");
		projs[2].setSpecificationPath("client/userInterface");
		projs[2].setWiki("http://en.wikipedia.org/wiki/Tic-tac-toe");

		projs[3] = new Project();
		projs[3].setName("JDK Tools.jar");
		projs[3].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[3].setRepositoryURL("http://javatoolssource.googlecode.com/svn");
		projs[3].setRoot("/trunk/src/");

		projs[4] = new Project();
		projs[4].setName("Agile Help");
		projs[4].setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		projs[4].setRepositoryURL("https://agilehelp.googlecode.com/svn");
		projs[4].setRoot("/trunk/src/");
		projs[4].setTestRoot("/trunk/test/");
		projs[4].setDomain("helpagile");
		projs[4].setSpecificationPath("client/userInterface");

		return projs;
	}
}
