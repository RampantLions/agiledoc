package com.agiledoc.shared.model;

import java.io.Serializable;
import java.util.Date;

public class Productivity implements Serializable {

	private Date date;

	private int toDoCounts;

	private int userTaskCounts;

	private int businessTaskCounts;

	private int classesCounts;

	private int stepsCounts;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getToDoCounts() {
		return toDoCounts;
	}

	public void setToDoCounts(int toDoCounts) {
		this.toDoCounts = toDoCounts;
	}

	public int getUserTaskCounts() {
		return userTaskCounts;
	}

	public void setUserTaskCounts(int userTaskCounts) {
		this.userTaskCounts = userTaskCounts;
	}

	public int getBusinessTaskCounts() {
		return businessTaskCounts;
	}

	public void setBusinessTaskCounts(int businessTaskCounts) {
		this.businessTaskCounts = businessTaskCounts;
	}

	public int getClassesCounts() {
		return classesCounts;
	}

	public void setClassesCounts(int classesCounts) {
		this.classesCounts = classesCounts;
	}

	public int getStepsCounts() {
		return stepsCounts;
	}

	public void setStepsCounts(int stepsCounts) {
		this.stepsCounts = stepsCounts;
	}

}
