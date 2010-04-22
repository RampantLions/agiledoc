package com.agiledoc.client.view.performance;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 */
public class PerformanceView {

	public static VerticalPanel vpChart = new VerticalPanel();

	public static void init() {

		GlobalVariables.getVP_BODY().clear();

		countPerformance();

		GlobalVariables.setVP_BODY(preparePage());
	}

	public static void countPerformance() {

		if (GlobalVariables.getProgressivePerformance() == null
				|| GlobalVariables.getProgressivePerformance().size() == 0) {

			PerformanceConvertion.count();
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
		vp1.add(ProgressivePerformanceTimelineChart.getChart());

		vp1.add(CumulativePerformanceColumnsChart.getChart());

		vp.add(vp1);
		return vp;
	}
}
