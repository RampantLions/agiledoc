package com.agiledoc.client.view.help;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetSourceClassHelp;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/19/2010
 */
public class HelpView {

	public static VerticalPanel vpBodyHelp = new VerticalPanel();

	/**
	 * 
	 * @author allineo
	 * @modified 04/19/2010
	 */
	public static void init() {

		GlobalVariables.getVP_BODY().clear();
		GlobalVariables.setVP_BODY(preparePage());

		new GetSourceClassHelp(GlobalVariables.getINIT_CLASS());
	}

	/**
	 * 
	 * @author allineo
	 * @modified 04/19/2010
	 */
	public static FlexTable preparePage() {

		FlexTable table = new FlexTable();
		table.setSize("97%", "100%");
		table.setBorderWidth(1);
		table.setCellPadding(15);

		table.getColumnFormatter().setWidth(0, "200");
		table.getFlexCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		table.setWidget(0, 0, TopicsList.createHelpMenu());

		vpBodyHelp.setSpacing(15);

		table.getFlexCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 1, vpBodyHelp);

		return table;
	}
}
