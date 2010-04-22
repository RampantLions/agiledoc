package com.agiledoc.client.view.measurements;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetSourceClassTasks;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/20/2010
 */
public class MeasurementsView {

	public static VerticalPanel vpChart = new VerticalPanel();

	/**
	 * @author allineo
	 * @modified 04/20/2010
	 */
	public static void init() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.setVP_BODY(preparePage());

		new GetSourceClassTasks(GlobalVariables.getINIT_CLASS());
	}

	/**
	 * 
	 * @author allineo
	 * @modified 04/20/2010
	 */
	public static VerticalPanel preparePage() {

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// vp1.add(vpChart);
		vp1.add(MeasurementsChart.getChart());

		vp.add(vp1);
		return vp;
	}
}
