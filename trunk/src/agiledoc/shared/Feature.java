package agiledoc.shared;

import java.io.Serializable;

public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;

	private String featureName;

	private String task;

	private int priority;

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
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

}
