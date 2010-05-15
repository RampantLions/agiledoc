package com.agiledoc.shared.model;

import java.io.Serializable;

public class Classedoc implements Serializable {

	private String fullName;

	private String className;

	private String description;

	private String modifiers;

	private String superclass;

	private String[] imports;

	private Field[] fields;

	private Method[] constructors;

	private Method[] methods;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public Method[] getMethods() {
		return methods;
	}

	public void setMethods(Method[] methods) {
		this.methods = methods;
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

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

}
