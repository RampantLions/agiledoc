package agiledoc.shared;

import java.io.Serializable;
import java.util.Date;

public class Entry implements Serializable {

	// private Pack pack;

	// private Classedoc classeDoc;

	private static final long serialVersionUID = 1L;

	private String classPath;

	private String className;

	private Date dateModified;

	private Feature feature;

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

}
