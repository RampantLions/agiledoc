package com.agiledoc.client.util;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FormField extends HorizontalPanel {

	public FormField(String label, Widget field) {

		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label title = new Label(label + ": ");
		title.setWidth("100");
		add(title);

		add(field);
	}
}
