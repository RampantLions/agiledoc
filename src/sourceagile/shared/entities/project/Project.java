package sourceagile.shared.entities.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Entity
 */
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String REPOSITORY_TYPE_SUBVERSION = "Subversion";
	public static final String REPOSITORY_TYPE_GIT = "Git";
	public static final String REPOSITORY_TYPE_XML = "XML";

	private Long projectID;

	private String name;

	private String description;

	private String repositoryType;

	private String repositoryURL;

	private String root;

	private String testRoot;

	private String domain;

	private String relatedLinks;

	private List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

	private List<ProjectBacklog> projectBacklog = new ArrayList<ProjectBacklog>();

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRepositoryType() {
		return repositoryType;
	}

	public void setRepositoryType(String repositoryType) {
		this.repositoryType = repositoryType;
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

	public String getRelatedLinks() {
		return relatedLinks;
	}

	public void setRelatedLinks(String relatedLinks) {
		this.relatedLinks = relatedLinks;
	}

	public List<ProjectComponents> getProjectComponents() {
		return projectComponents;
	}

	public void setProjectComponents(List<ProjectComponents> projectComponents) {
		this.projectComponents = projectComponents;
	}

	public List<ProjectBacklog> getProjectBacklog() {
		return projectBacklog;
	}

	public void setProjectBacklog(List<ProjectBacklog> projectBacklog) {
		this.projectBacklog = projectBacklog;
	}

}
