package sourceagile.shared.entities.entry;

import java.io.Serializable;

public class ClassDocumentation implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TODO_STATUS = "ToDo";
	public static final String INPROGRESS_STATUS = "InProgress";
	public static final String BLOCKED_STATUS = "Blocked";

	public static final String MAIN_FEATURE_TAG = "MainFeature";
	public static final String FEATURE_TAG = "Feature";
	public static final String USER_INTERFACE_TAG = "UserInterface";
	public static final String ARCHITECTURE_TAG = "Architecture";
	public static final String ENTITY_TAG = "Entity";

	private String className;

	private String classPackage;

	private String description;

	private String modifiers;

	private String superclass;

	private String[] imports;

	private Field[] fields;

	private Method[] constructors;

	private Method[] methods;

	private String classStatus;

	private String tagType;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassPackage() {
		return classPackage;
	}

	public void setClassPackage(String classPackage) {
		this.classPackage = classPackage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModifiers() {
		return modifiers;
	}

	public void setModifiers(String modifiers) {
		this.modifiers = modifiers;
	}

	public String getSuperclass() {
		return superclass;
	}

	public void setSuperclass(String superclass) {
		this.superclass = superclass;
	}

	public String[] getImports() {
		return imports;
	}

	public void setImports(String[] imports) {
		this.imports = imports;
	}

	public Method[] getConstructors() {
		return constructors;
	}

	public void setConstructors(Method[] constructors) {
		this.constructors = constructors;
	}

	public Method[] getMethods() {
		return methods;
	}

	public void setMethods(Method[] methods) {
		this.methods = methods;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public String getClassStatus() {
		return classStatus;
	}

	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}

	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

}
