package sourceagile.shared.entities.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/** 
 * @entity 
 */
@PersistenceCapable
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String REPOSITORY_TYPE_SUBVERSION = "Subversion";
	public static final String REPOSITORY_TYPE_GIT = "Git";

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long projectID;

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
	private String specificationPath;

	@Persistent
	private String wiki;

	@Persistent(defaultFetchGroup = "true")
	private List<ProjectComponents> projectComponents = new ArrayList<ProjectComponents>();

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

	public List<ProjectComponents> getProjectComponents() {
		return projectComponents;
	}

	public void setProjectComponents(List<ProjectComponents> projectComponents) {
		this.projectComponents = projectComponents;
	}

}
