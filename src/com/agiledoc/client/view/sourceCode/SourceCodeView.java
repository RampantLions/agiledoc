package com.agiledoc.client.view.sourceCode;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetSourceCode;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * In the features view, the system lists all the classes located inside the
 * view path of the project.
 */
public class SourceCodeView {

	public static VerticalPanel vpBody = new VerticalPanel();

	// private static HorizontalPanel hpViewOptions = new HorizontalPanel();

	public SourceCodeView() {

		new SourceCodeView(null);
	}

	public SourceCodeView(Classe classe) {

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

		// hpViewOptions.setSpacing(10);
		// hpMain.add(hpViewOptions);

		table.getFlexCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_TOP);
		table.setWidget(0, 1, hpMain);

		GlobalVariables.setVP_BODY(table);

		table.setWidget(0, 0, new SourceCodeList());

		new GetSourceCode(GlobalVariables.getProject().getClasses()[0], vpBody);
	}

	public static void showSourceCode(Widget widget) {

		vpBody.clear();
		vpBody.add(widget);

		// hpViewOptions.clear();
		// hpViewOptions.add(new FeatureViewOptions(classe));
	}

}
