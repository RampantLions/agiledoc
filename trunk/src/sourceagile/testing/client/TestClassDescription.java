package sourceagile.testing.client;

import sourceagile.development.client.features.ButtonTest;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;



/** 
 * Show the specification of the Test Class. Connect the source code straight with its Unit Testing in a very precise way. 
 * 
 * @MainFeature 
 */
public class TestClassDescription extends VerticalPanel {

	public TestClassDescription(ClassFile classEntry, ClassFile testEntry) {

		OptionsIcons.buttonTest.setHTML(ButtonTest.imagePressed);

		if (testEntry != null) {

			FeatureVizualizationPanel.featureContent.clear();

			FeatureVizualizationPanel.featureContent
					.add(new ButtonViewTestSourceCode(testEntry));

			Label labelSpace = new Label(" ");
			labelSpace.setHeight("10px");

			FeatureVizualizationPanel.featureContent.add(labelSpace);

			new FeatureDescription(testEntry);

		} else {

			FeatureVizualizationPanel.featureContent.clear();

			FeatureVizualizationPanel.featureContent.add(new NoTestFoundPanel(
					classEntry));
		}
	}
}
