package com.agiledoc.client.view.features;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * In the features view, the system lists all the classes located inside the
 * view path of the project.
 */
public class FeaturesView {

	public static VerticalPanel vpBody = new VerticalPanel();
	public static HorizontalPanel hpViewOptions = new HorizontalPanel();

	public FeaturesView() {

		GlobalVariables.getVP_BODY().clear();

		FlexTable table = new FlexTable();
		table.setSize("97%", "100%");
		table.setBorderWidth(1);
		table.setCellPadding(15);

		table.getColumnFormatter().setWidth(0, "200");
		table.getFlexCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		table.getFlexCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_TOP);

		HorizontalPanel hpMain = new HorizontalPanel();

		vpBody.setWidth("700");
		vpBody.setSpacing(15);
		hpMain.add(vpBody);

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(10);

		hpMain.add(hp);

		table.getFlexCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 1, hpMain);

		GlobalVariables.setVP_BODY(table);

		table.setWidget(0, 0, new FeaturesList());
	}

}
