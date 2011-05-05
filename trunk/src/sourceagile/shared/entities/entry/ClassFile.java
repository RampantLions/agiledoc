package sourceagile.shared.entities.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import sourceagile.shared.entities.User;

/**
 * 
 * @Entity
 */
public class ClassFile implements Serializable, Comparable<ClassFile> {

	private static final long serialVersionUID = 1L;

	public static String EXTENSION_FEATURE = "feature";
	public static String EXTENSION_JAVA = "java";
	public static String EXTENSION_JSP = "jsp";
	public static String EXTENSION_JS = "js";
	public static String EXTENSION_CSS = "css";
	public static String EXTENSION_HTML = "html";
	public static String EXTENSION_XML = "xml";

	private String classDomain;

	private String filePath;

	private String fileName;

	private String fileExtension;

	private Feature feature;

	private ClassDocumentation classDoc;

	private Date dateModified;

	private User user;

	private String sourceCode;

	private String classLocale;

	private ArrayList<String> sourceCodeTokenized;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
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

	public String getClassLocale() {
		return classLocale;
	}

	public void setClassLocale(String classLocale) {
		this.classLocale = classLocale;
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

		String thisClass = this.classDomain + this.filePath + "/"
				+ this.fileName;
		String thatClass = that.classDomain + that.filePath + "/"
				+ that.fileName;

		return thisClass.compareTo(thatClass);
	}

	@Override
	public String toString() {

		String filePath = this.fileName;

		if (this.filePath != null && this.filePath.length() > 0) {

			filePath = this.filePath + "/" + this.fileName;

		}

		return filePath;
	}

}
