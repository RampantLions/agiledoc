package com.agiledoc.client.view.performance;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;

/**
 * @userTask
 */
public class CumulativePerformanceColumnsChart {

	public static ColumnChart getChart() {

		Options options = Options.create();
		options.setHeight(240);
		options.setTitle("Cumulative Performance");
		options.setWidth(800);
		options.set3D(true);
		options.setShowCategories(true);
		options.setEnableTooltip(true);

		DataTable data = DataTable.create();

		setColumns(data);

		setRows(data, GlobalVariables.getCumulativePerformance());

		ColumnChart chart = new ColumnChart(data, options);

		return chart;
	}

	private static void setRows(DataTable data, Performance totals) {

		data.addRows(1);

		data.setValue(0, 0, totals.getToDoCounts());
		data.setValue(0, 1, totals.getUserTaskCounts());
		data.setValue(0, 2, totals.getBusinessTaskCounts());
		data.setValue(0, 3, totals.getClassesCounts());
		data.setValue(0, 4, totals.getStepsCounts());
	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "User Tasks");
		data.addColumn(ColumnType.NUMBER, "Business Tasks");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");
	}

}
