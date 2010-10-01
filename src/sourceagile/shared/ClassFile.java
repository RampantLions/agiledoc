package sourceagile.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ClassFile implements Serializable, Comparable<ClassFile> {

	private static final long serialVersionUID = 1L;

	private String classDomain;

	private String classPath;

	private String className;

	private Feature feature;

	private ClassDocumentation classDoc;

	private Date dateModified;

	private User user;

	private String sourceCode;

	private ArrayList<String> sourceCodeTokenized;

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

	public String getClassDomain() {
		return classDomain;
	}

	public void setClassDomain(String classDomain) {
		this.classDomain = classDomain;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public ArrayList<String> getSourceCodeTokenized() {
		return sourceCodeTokenized;
	}

	public void setSourceCodeTokenized(ArrayList<String> sourceCodeTokenized) {
		this.sourceCodeTokenized = sourceCodeTokenized;
	}

	@Override
	public int compareTo(ClassFile that) {

		String thisClass = this.classDomain + this.classPath + "/"
				+ this.className;
		String thatClass = that.classDomain + that.classPath + "/"
				+ that.className;

		return thisClass.compareTo(thatClass);
	}

	@Override
	public String toString() {

		String filePath = this.className;

		if (!(this.classPath == null || this.classPath.length() == 0)) {

			filePath = this.classPath.replaceAll("\\.", "/") + "/" + filePath;

			if (this.classDomain != null) {

				filePath = this.classDomain.replaceAll("\\.", "/") + "/"
						+ filePath;
			}
		}

		return filePath;
	}

}
