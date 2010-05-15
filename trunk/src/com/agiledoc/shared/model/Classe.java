package com.agiledoc.shared.model;

import java.io.Serializable;
import java.util.Date;

public class Classe implements Serializable {

	private Pack pack;

	private Classedoc classeDoc;

	private String name;

	private String task;

	private int priority;

	private Date dateModified;

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Classedoc getClasseDoc() {
		return classeDoc;
	}

	public void setClasseDoc(Classedoc classeDoc) {
		this.classeDoc = classeDoc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

}
