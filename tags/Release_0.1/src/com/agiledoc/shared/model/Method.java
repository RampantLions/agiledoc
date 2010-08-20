package com.agiledoc.shared.model;

import java.io.Serializable;

/**
 * @author allineo
 * @modified 04/12/2010
 */
public class Method implements Serializable {

	private String name;

	private String spacedName;

	private String returnType;

	private String parameters;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getSpacedName() {
		return spacedName;
	}

	public void setSpacedName(String spacedName) {
		this.spacedName = spacedName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
