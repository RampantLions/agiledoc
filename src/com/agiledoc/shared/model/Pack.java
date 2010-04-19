package com.agiledoc.shared.model;

import java.io.Serializable;

/**
 * @author allineo
 * @modified 04/15/2010
 */
public class Pack implements Serializable {

	private String fullName;

	private String name;

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

}
