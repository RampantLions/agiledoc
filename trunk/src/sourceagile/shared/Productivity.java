package sourceagile.shared;

import java.io.Serializable;
import java.util.Date;

public class Productivity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;

	private int toDoCount;

	private int featureCount;

	private int classesCount;

	private int classActivityCount;

	private int stepsCount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getToDoCount() {
		return toDoCount;
	}

	public void setToDoCount(int toDoCount) {
		this.toDoCount = toDoCount;
	}

	public int getFeatureCount() {
		return featureCount;
	}

	public void setFeatureCount(int featureCount) {
		this.featureCount = featureCount;
	}

	public int getClassesCount() {
		return classesCount;
	}

	public void setClassesCount(int classesCount) {
		this.classesCount = classesCount;
	}

	public int getClassActivityCount() {
		return classActivityCount;
	}

	public void setClassActivityCount(int classActivityCount) {
		this.classActivityCount = classActivityCount;
	}

	public int getStepsCount() {
		return stepsCount;
	}

	public void setStepsCount(int stepsCount) {
		this.stepsCount = stepsCount;
	}

}
