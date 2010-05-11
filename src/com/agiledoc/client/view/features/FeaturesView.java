package com.agiledoc.client.view.features;

import com.agiledoc.client.view.features.FeaturesList;
import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * In the features view, the system lists all the classes located inside the
 * view path of the project.
 */
public class FeaturesView {

	public static VerticalPanel vpBodyScope = new VerticalPanel();

	public FeaturesView() {

		GlobalVariables.getVP_BODY().clear();

		FlexTable table = new FlexTable();
		table.setSize("97%", "100%");
		table.setBorderWidth(1);
		table.setCellPadding(15);

		featuresList(table);

		featureShow(table);

		GlobalVariables.setVP_BODY(table);
	}

	private static void featuresList(FlexTable table) {

		table.getColumnFormatter().setWidth(0, "200");
		table.getFlexCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		table.getFlexCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 0, new FeaturesList());
	}

	private static void featureShow(FlexTable table) {

		vpBodyScope.setSpacing(15);

		table.getFlexCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 1, vpBodyScope);
	}

}
