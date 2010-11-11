package sourceagile.shared.entities.project;

import java.io.Serializable;

public class ProjectComponents implements Serializable {

	private static final long serialVersionUID = 1L;

	private String componentName;

	private String componentPath;

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

	public ProjectComponents(String componentName, String componentPath) {

		this.componentName = componentName;
		this.componentPath = componentPath;
	}

}
