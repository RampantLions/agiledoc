/** 
 * TODO: Change the name Steps for Methods.
 * 
 * @todo 
 */ package sourceagile.client.activity;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;

public class ActivityColumnsChart extends VerticalPanel {

	public ActivityColumnsChart() {

		Options options = Options.create();
		options.setHeight(240);
		// options.setTitle("Cumulative Activity");
		options.setWidth(800);
		options.set3D(true);
		options.setShowCategories(true);
		options.setEnableTooltip(true);

		DataTable data = DataTable.create();

		setColumns(data);

		// setRows(data,
		// GlobalVariables.getProject().getCumulativeProductivity());

		ColumnChart chart = new ColumnChart(data, options);

		this.add(chart);
	}

	/*
	 * private static void setRows(DataTable data, Productivity totals) {
	 * 
	 * data.addRows(1);
	 * 
	 * data.setValue(0, 0, totals.getToDoCounts()); data.setValue(0, 1,
	 * totals.getFeatureCounts()); data.setValue(0, 2,
	 * totals.getClassesCounts()); data.setValue(0, 3, totals.getStepsCounts());
	 * }
	 */

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "Features");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");
	}

}
