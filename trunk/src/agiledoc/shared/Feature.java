package agiledoc.shared;

import java.io.Serializable;
import java.util.Date;

public class Feature implements Serializable {

	// private Pack pack;

	// private Classedoc classeDoc;

	private String name;

	private String task;

	private int priority;

	private Date dateModified;

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
