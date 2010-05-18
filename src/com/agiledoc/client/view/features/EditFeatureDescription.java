package com.agiledoc.client.view.features;

import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditFeatureDescription extends VerticalPanel {

	public EditFeatureDescription(Classe classe) {

		setWidth("700");
		
		add(FeaturePage.featureName(classe));
		add(featureDescription(classe));

		if (classe.getClasseDoc().getMethods() != null) {
			add(featureSteps(classe.getClasseDoc().getMethods()));
		}

		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		add(saveButton());
	}

	private static HorizontalPanel featureDescription(final Classe classe) {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(20);

		TextArea textArea = new TextArea();
		textArea.setSize("600", "40");
		textArea.setText(classe.getClasseDoc().getDescription());

		hp.add(textArea);
		return hp;
	}

	private static Grid featureSteps(final Method[] meths) {

		Grid table = new Grid(meths.length * 3, 2);

		table.getColumnFormatter().setWidth(0, "40");

		for (int i = 0; i < meths.length; i++) {

			Method meth = meths[i];

			table.setWidget((i * 3), 1, new HTML("<B>" + meth.getSpacedName()
					+ "</B>"));

			TextArea textArea = new TextArea();
			textArea.setSize("550", "40");
			textArea.setText(meth.getDescription());

			table.setWidget((i * 3 + 1), 1, textArea);

			table.setWidget((i * 3 + 2), 0, new Label(" "));
		}

		return table;
	}

	private static Button saveButton() {

		Button button = new Button("Save",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		return button;
	}
}
