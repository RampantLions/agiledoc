package com.agiledoc.client.view.sourceCode;

import com.agiledoc.client.view.features.FeaturePage;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the source code to the file applied to the feature.
 * 
 * @todo 5
 */
public class SourceCodePage extends VerticalPanel {

	public SourceCodePage(Classe classe, String sourceCode) {

		setWidth("700");

		add(FeaturePage.featureName(classe));

		ScrollPanel spanel = new ScrollPanel();

		spanel.add(new Label(sourceCode));
		
		add(spanel);

	}
}
