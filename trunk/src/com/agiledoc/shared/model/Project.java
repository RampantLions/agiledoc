package com.agiledoc.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {

	private String name;

	private String root;

	private String domain;

	private String featureFullPackage;

	private String featureRelativePackage;

	private Classe[] classes;

	private Classe[] features;

	private List<TodoClasse> todoList;

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
		this.featureFullPackage = domain + "." + featureRelativePackage;
	}

	public String getFeatureFullPackage() {
		return featureFullPackage;
	}

	public String getFeatureRelativePackage() {
		return featureRelativePackage;
	}

	public void setFeatureRelativePackage(String featureRelativePackage) {
		this.featureRelativePackage = featureRelativePackage;
		this.featureFullPackage = domain + "." + featureRelativePackage;
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

	public Classe[] getFeatures() {
		return features;
	}

	public void setFeatures(Classe[] features) {
		this.features = features;
	}

	public List<TodoClasse> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoClasse> todoList) {
		this.todoList = todoList;
	}

}
