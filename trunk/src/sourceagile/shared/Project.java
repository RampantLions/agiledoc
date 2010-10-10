package sourceagile.shared;

import java.io.Serializable;

public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String repositoryURL;

	private String root;

	private String testRoot;

	private String domain;

	private String specificationPath;

	private String wiki;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getDomain() {
		return domain;
	}

	public String getRepositoryURL() {
		return repositoryURL;
	}

	public void setRepositoryURL(String repositoryURL) {
		this.repositoryURL = repositoryURL;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTestRoot() {
		return testRoot;
	}

	public void setTestRoot(String testRoot) {
		this.testRoot = testRoot;
	}

	public String getSpecificationPath() {
		return specificationPath;
	}

	public void setSpecificationPath(String specificationPath) {
		this.specificationPath = specificationPath;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

}