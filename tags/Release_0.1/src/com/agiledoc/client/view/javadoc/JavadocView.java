package com.agiledoc.client.view.javadoc;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class JavadocView {

	public static VerticalPanel vpClassesJavadoc = new VerticalPanel();
	public static VerticalPanel vpBodyJavadoc = new VerticalPanel();

	public static void init() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.setVP_BODY(preparePage());

		vpClassesJavadoc.clear();
		vpClassesJavadoc.add(ClassesList.getClassesPanel(null));

		JavadocView.vpBodyJavadoc.add(new JavadocClassPage(GlobalVariables
				.getProject().getClasses()[0]));
	}

	public static FlexTable preparePage() {

		FlexTable table = new FlexTable();
		table.setBorderWidth(1);
		table.setSize("97%", "100%");

		table.getColumnFormatter().setWidth(0, "300");

		table.getFlexCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 0, PacksList.getPacksPanel());

		table.getFlexCellFormatter().setVerticalAlignment(1, 0,
				HasVerticalAlignment.ALIGN_TOP);
		table.getFlexCellFormatter().setHeight(1, 0, "400");
		table.setWidget(1, 0, vpClassesJavadoc);

		vpBodyJavadoc.setSpacing(20);
		vpBodyJavadoc.setSize("100%", "100%");
		table.setWidget(0, 1, vpBodyJavadoc);
		table.getFlexCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_TOP);
		table.getFlexCellFormatter().setRowSpan(0, 1, 2);

		return table;
	}
}
