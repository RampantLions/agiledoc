package sourceagile.shared;

import java.io.Serializable;
import java.util.Date;

public class Entry implements Serializable, Comparable<Entry> {

	private static final long serialVersionUID = 1L;

	private String classPath;

	private String className;

	private Feature feature;

	private ClassDocumentation classDoc;

	private Date dateModified;

	private User user;

	private String textContent;

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

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public ClassDocumentation getClassDoc() {
		return classDoc;
	}

	public void setClassDoc(ClassDocumentation classDoc) {
		this.classDoc = classDoc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int compareTo(Entry that) {

		String thisClass = this.classPath + "/" + this.className;
		String thatClass = that.classPath + "/" + that.className;

		return thisClass.compareTo(thatClass);
	}

	@Override
	public String toString() {

		if (this.classPath == null || this.classPath.length() == 0) {

			return this.className;
		} else {

			return this.classPath + "/" + this.className;
		}
	}

}
