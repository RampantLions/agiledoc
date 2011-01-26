package sourceagile.server.databaseAccess.entities;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class ProjectComponents implements Serializable,
		Comparable<ProjectComponents> {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key componentID;

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

	public Key getComponentID() {
		return componentID;
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
