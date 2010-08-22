package agiledoc.shared;

import java.io.Serializable;
import java.util.Date;

public class Entry implements Serializable {

	// private Pack pack;

	// private Classedoc classeDoc;

	private static final long serialVersionUID = 1L;

	private String entryName;

	private boolean isFile;

	private Date dateModified;

	private Feature feature;

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public boolean isFile() {
		return isFile;
	}

	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

}
