package agiledoc.client.features;

import agiledoc.shared.Entry;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FeatureSource extends VerticalPanel {

	public FeatureSource(Entry entry) {

		FeatureVisualization.featureContent.clear();

		/*
		 * String sourceCode = entry.getTextContent();
		 * 
		 * sourceCode = sourceCode.replaceAll("\n", "<br>"); sourceCode =
		 * sourceCode.replaceAll("\t",
		 * "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		 * 
		 * FeatureVisualization.featureContent.add(new HTML(sourceCode));
		 */

		new SourceEditor(entry.getTextContent());

	}

}
