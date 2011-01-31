package sourceagile.shared.entities.project;

import java.io.Serializable;

/**
 * 
 * @Entity
 */
public class ProjectComponents implements Serializable,
		Comparable<ProjectComponents> {

	private static final long serialVersionUID = 1L;

	private Long componentID;

	private String componentName;

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
