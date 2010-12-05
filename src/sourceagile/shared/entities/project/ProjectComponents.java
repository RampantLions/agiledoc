package sourceagile.shared.entities.project;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ProjectComponents implements Serializable,
		Comparable<ProjectComponents> {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long componentID;

	@Persistent
	private String componentName;

	@Persistent
	private String componentPath;

	public ProjectComponents() {

	}

	public ProjectComponents(String componentName, String componentPath) {

		this.componentName = componentName;
		this.componentPath = componentPath;
	}

	public Long getComponentID() {
		return componentID;
	}

	public void setComponentID(Long componentID) {
		this.componentID = componentID;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentPath() {
		return componentPath;
	}

	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}

	@Override
	public int compareTo(ProjectComponents that) {

		return this.componentName.compareTo(that.componentName);
	}

}
