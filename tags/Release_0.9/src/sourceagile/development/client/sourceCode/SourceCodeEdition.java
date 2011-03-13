package sourceagile.development.client.sourceCode;

import sourceagile.development.client.features.FeatureVizualizationPanel;

import com.weborient.codemirror.client.CodeMirrorConfiguration;
import com.weborient.codemirror.client.CodeMirrorEditorWidget;

/**
 * Edit the source code in a web bases.
 * 
 * @MainFeature
 */
public class SourceCodeEdition {

	public SourceCodeEdition(String classSource) {

		FeatureVizualizationPanel.featureContent.clear();

		// use the configuration class in order
		// to override the default widget configuraions

		CodeMirrorConfiguration configuration = new CodeMirrorConfiguration();
		// configuration.setTagSelectorLabel("Templates: ");
		// configuration.setListBoxPreSets("<html></html>", "<div></div>");

		configuration.setWidth("700px");
		configuration.setHeight("600px");

		// pass the configuration object to the widget

		CodeMirrorEditorWidget widget = new CodeMirrorEditorWidget(
				configuration);

		FeatureVizualizationPanel.featureContent.add(widget);

		// these two methods should be called after the widget has been added
		// other wise you'll get an error

		widget.setText(classSource);

		// String text = widget.getText();

	}
}
