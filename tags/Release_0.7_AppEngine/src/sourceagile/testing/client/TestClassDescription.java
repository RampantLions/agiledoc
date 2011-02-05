package sourceagile.testing.client;

import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the specification of the Test Class.
 * 
 * @Feature
 */
public class TestClassDescription extends VerticalPanel {

	public TestClassDescription(ClassFile classEntry, ClassFile testEntry) {

		if (testEntry != null) {

			FeatureVizualizationPanel.featureContent.clear();

			FeatureVizualizationPanel.featureContent
					.add(new ButtonViewTestSourceCode(testEntry));

			FeatureVizualizationPanel.featureContent.add(new Label(" "));

			new FeatureDescription(testEntry);

		} else {

			FeatureVizualizationPanel.featureContent.clear();

			FeatureVizualizationPanel.featureContent.add(new NoTestFoundPanel(
					classEntry));
		}
	}
}