package sourceagile.shared;

import java.io.Serializable;

public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;

	private String featureFolder;

	private String featureName;

	public String getFeatureFolder() {
		return featureFolder;
	}

	public void setFeatureFolder(String featureFolder) {
		this.featureFolder = featureFolder;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	@Override
	public String toString() {

		return featureFolder + "." + featureName;
	}

}
