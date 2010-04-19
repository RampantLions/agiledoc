package com.agiledoc.client.view.javadoc;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/13/2010
 */
public class JavadocView {

	public static VerticalPanel vpClassesJavadoc = new VerticalPanel();
	public static VerticalPanel vpBodyJavadoc = new VerticalPanel();

	/**
	 * 
	 * @author allineo
	 * @modified 04/19/2010
	 */
	public static void init() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.setVP_BODY(preparePage());

		vpClassesJavadoc.clear();
		vpClassesJavadoc.add(ClassesList.getClassesPanel(null));

		new ClassPage(GlobalVariables.getCLASSES_LIST()[0]);
	}

	/**
	 * @author allineo
	 * @modified 04/19/2010
	 */
	public static FlexTable preparePage() {

		FlexTable table = new FlexTable();
		table.setBorderWidth(1);
		table.setSize("97%", "100%");

		table.getColumnFormatter().setWidth(0, "300");
		table.setWidget(0, 0, PacksList.getPacksPanel());
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
