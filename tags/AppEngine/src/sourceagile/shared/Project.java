package sourceagile.shared;

import java.io.Serializable;

public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String repositoryURL;

	private String root;

	private String domain;

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

}
