package sourceagile.shared.entities;

import java.io.Serializable;
import java.util.Date;

public class Productivity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;

	private int toDoCount;

	private int featureCount;

	private int classesCount;

	private int classActivityCount;

	private int methodsCount;

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

	public int getMethodsCount() {
		return methodsCount;
	}

	public void setMethodsCount(int methodsCount) {
		this.methodsCount = methodsCount;
	}

}
