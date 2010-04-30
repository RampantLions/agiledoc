package com.agiledoc.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Project implements Serializable {

	private String name;

	private String root;

	private String domain;

	private String viewPackage;

	private Classe[] classes;

	private ArrayList<Productivity> progressiveProductivity;

	private Productivity cumulativeProductivity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getViewPackage() {
		return viewPackage;
	}

	public void setViewPackage(String viewPackage) {
		this.viewPackage = viewPackage;
	}

	public Classe[] getClasses() {
		return classes;
	}

	public void setClasses(Classe[] classes) {
		this.classes = classes;
	}

	public ArrayList<Productivity> getProgressiveProductivity() {
		return progressiveProductivity;
	}

	public void setProgressiveProductivity(
			ArrayList<Productivity> progressiveProductivity) {
		this.progressiveProductivity = progressiveProductivity;
	}

	public Productivity getCumulativeProductivity() {
		return cumulativeProductivity;
	}

	public void setCumulativeProductivity(Productivity cumulativeProductivity) {
		this.cumulativeProductivity = cumulativeProductivity;
	}

}
	