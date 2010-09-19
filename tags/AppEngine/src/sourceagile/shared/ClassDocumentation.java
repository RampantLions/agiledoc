package sourceagile.shared;

import java.io.Serializable;

public class ClassDocumentation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;

	private String modifiers;

	private String superclass;

	private String[] imports;

	private Field[] fields;

	private Method[] constructors;

	private Method[] methods;

	private boolean todo;

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

}
