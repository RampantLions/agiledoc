package sourceagile.shared.data;

import sourceagile.shared.Project;

public class ProjectsData {

	public static Project[] load() {

		Project[] projs = new Project[1];

		projs[0] = new Project();
		projs[0].setName("Source Agile");
		projs[0].setRepositoryURL("http://agiledoc.googlecode.com");
		projs[0].setRoot("/svn/trunk/src/");
		projs[0].setDomain("sourceagile/client");

		return projs;
	}
}
