package sourceagile.shared;

import java.io.Serializable;

public class ClassDocumentation implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TODO_TAG = "TODO";

	public static final String FEATURE_TAG = "feature";

	public static final String ARCHITECTURE_TAG = "architecture";

	private String className;

	private String classPackage;

	private String description;

	private String modifiers;

	private String superclass;

	private String[] imports;

	private Field[] fields;

	private Method[] constructors;

	private Method[] methods;

	private boolean todo;

	private boolean feature;
	
	private boolean architecture;

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

	public boolean isTodo() {
		return todo;
	}

	public void setTodo(boolean todo) {
		this.todo = todo;
	}

	public boolean isFeature() {
		return feature;
	}

	public void setFeature(boolean feature) {
		this.feature = feature;
	}

	public boolean isArchitecture() {
		return architecture;
	}

	public void setArchitecture(boolean architecture) {
		this.architecture = architecture;
	}
	
	

}
