package com.agiledoc.client.view.features;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;

/**
 * In the features view, the system lists all the classes located inside the
 * view path of the project.
 */
public class FeaturesView {

	public FeaturesView() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.getVP_BODY().add(new Label(" "));

		FlexTable table = new FlexTable();
		table.setBorderWidth(1);
		table.setCellPadding(15);

		table.getFlexCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		table.getFlexCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_TOP);

		GlobalVariables.getVP_BODY().add(table);

		table.setWidget(0, 0, new FeaturesList());
	}

}
