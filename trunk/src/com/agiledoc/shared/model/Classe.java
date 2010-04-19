package com.agiledoc.shared.model;

import java.io.Serializable;

/**
 * @author allineo
 * @modified 04/19/2010
 */
public class Classe implements Serializable {

	private String fullName;

	private String className;

	private String name;

	private String description;

	private Pack pack;

	private String modifiers;

	private String task;

	private int priority;

	private Classe[] links;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getModifiers() {
		return modifiers;
	}

	public void setModifiers(String modifiers) {
		this.modifiers = modifiers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Classe[] getLinks() {
		return links;
	}

	public void setLinks(Classe[] links) {
		this.links = links;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
