package com.agiledoc.shared.model;

import java.io.Serializable;

import com.agiledoc.shared.util.ChangeNames;

public class Pack implements Serializable {

	private String fullName;

	private String name;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
		this.name = ChangeNames.getLastNameSpaced(fullName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
