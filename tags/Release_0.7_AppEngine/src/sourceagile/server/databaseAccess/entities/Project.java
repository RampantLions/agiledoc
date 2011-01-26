package sourceagile.server.databaseAccess.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key projectID;

	@Persistent
	private String name;

	@Persistent
	@Column(jdbcType = "LONGVARCHAR")
	private String description;

	@Persistent
	private String repositoryType;

	@Persistent
	private String repositoryURL;

	@Persistent
	private String root;

	@Persistent
	private String testRoot;

	@Persistent
	private String domain;

	@Persistent
	@Column(jdbcType = "LONGVARCHAR")
	private String relatedLinks;

	@Persistent(defaultFetchGroup = "true")
	private List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

	@Persistent(defaultFetchGroup = "true")
	private List<ProjectBacklog> projectBacklog = new ArrayList<ProjectBacklog>();

	public Key getProjectID() {
		return projectID;
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
