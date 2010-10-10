package sourceagile.client.userFeatures.testing;

import sourceagile.client.userFeatures.features.FeatureDescription;
import sourceagile.client.userFeatures.specification.classViewOptions.ClassVizualizationPanel;
import sourceagile.shared.ClassFile;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the specification of the Test Class.
 * 
 * @feature
 */
public class TestClassDescription extends VerticalPanel {

	public TestClassDescription(ClassFile testEntry) {

		if (testEntry != null) {

			new FeatureDescription(testEntry);

		} else {

			ClassVizualizationPanel.featureContent.clear();

			this.add(new Label("No test created."));

			ClassVizualizationPanel.featureContent.add(this);
		}
	}

}
