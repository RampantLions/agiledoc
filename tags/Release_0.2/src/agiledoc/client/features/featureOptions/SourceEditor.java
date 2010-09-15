package agiledoc.client.features.featureOptions;


import com.weborient.codemirror.client.CodeMirrorConfiguration;
import com.weborient.codemirror.client.CodeMirrorEditorWidget;

public class SourceEditor {

	public SourceEditor(String classSource) {

		// use the configuration class in order
		// to override the default widget configuraions

		CodeMirrorConfiguration configuration = new CodeMirrorConfiguration();
		// configuration.setTagSelectorLabel("Temlates: ");
		// configuration.setListBoxPreSets("<html></html>", "<div></div>");

		configuration.setWidth("700px");
		configuration.setHeight("600px");

		// pass the configuration object to the widget

		CodeMirrorEditorWidget widget = new CodeMirrorEditorWidget(
				configuration);

		FeatureContentPanel.featureContent.add(widget);

		// these two methods should be called after the widget has been added
		// other wise you'll get an error

		widget.setText(classSource);
		
		// String text = widget.getText();

	}
}
