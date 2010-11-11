package sourceagile.shared.entities.entry;

import java.io.Serializable;


public class ClassDocumentation implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TODO_TAG = "TODO";

	public static final String FEATURE_TAG = "feature";

	public static final String ARCHITECTURE_TAG = "architecture";

	public static final String ENTITY_TAG = "entity";

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

	public boolean isTodo() {
		return todo;
	}

	public void setTodo(boolean todo) {
		this.todo = todo;
	}

	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

}
