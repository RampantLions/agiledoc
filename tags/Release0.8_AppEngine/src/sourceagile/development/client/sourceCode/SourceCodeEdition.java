package sourceagile.development.client.sourceCode;

import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.weborient.codemirror.client.CodeMirrorConfiguration;
import com.weborient.codemirror.client.CodeMirrorEditorWidget;

/**
 * Edit the source code in a web bases.
 * 
 * @MainFeature
 */
public class SourceCodeEdition {

	public SourceCodeEdition(ClassFile entry) {

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

		widget.setText(entry.getSourceCode());

		// String text = widget.getText();

		FeatureVizualizationPanel.featureContent
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(20);

		hp.add(new ButtonInProgress(entry));

		hp.add(new ButtonBlocked(entry));

		FeatureVizualizationPanel.featureContent.add(hp);

	}
}
