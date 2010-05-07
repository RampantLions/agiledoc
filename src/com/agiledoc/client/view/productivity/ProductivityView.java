package com.agiledoc.client.view.productivity;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProductivityView {

	public static VerticalPanel vpChart = new VerticalPanel();

	public static void init() {

		GlobalVariables.getVP_BODY().clear();

		countPerformance();

		GlobalVariables.setVP_BODY(preparePage());
	}

	public static void countPerformance() {

		if (GlobalVariables.getProject().getProgressiveProductivity() == null
				|| GlobalVariables.getProject().getProgressiveProductivity()
						.size() == 0) {

			ProductivityConvertion.count();
		}
	}

	public static VerticalPanel preparePage() {

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// vp1.add(vpChart);
		vp1.add(ProgressiveProductivityTimelineChart.getChart());

		vp1.add(CumulativeProductivityColumnsChart.getChart());

		vp.add(vp1);
		return vp;
	}
}
