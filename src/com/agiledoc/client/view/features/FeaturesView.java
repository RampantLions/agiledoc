package com.agiledoc.client.view.features;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetSourceClassTasks;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturesView {

	public static VerticalPanel vpBodyScope = new VerticalPanel();

	public static void init() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.setVP_BODY(preparePage());

		new GetSourceClassTasks(GlobalVariables.INIT_CLASS);
	}

	public static FlexTable preparePage() {

		FlexTable table = new FlexTable();
		table.setSize("97%", "100%");
		table.setBorderWidth(1);
		table.setCellPadding(15);

		table.getColumnFormatter().setWidth(0, "200");
		table.getFlexCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		table.setWidget(0, 0, FeaturesList.createMenu());

		vpBodyScope.setSpacing(15);

		table.getFlexCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 1, vpBodyScope);

		return table;
	}

}
