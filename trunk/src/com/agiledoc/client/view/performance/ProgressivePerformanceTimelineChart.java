package com.agiledoc.client.view.performance;

import java.util.ArrayList;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.Options;

/**
 * @userTask
 */
public class ProgressivePerformanceTimelineChart {

	public static AnnotatedTimeLine getChart() {

		Options options = Options.create();
		options.setDisplayAnnotations(true);

		DataTable data = DataTable.create();

		setColumns(data);

		setRows(data, GlobalVariables.getProgressivePerformance());

		AnnotatedTimeLine chart = new AnnotatedTimeLine(data, options, "800px",
				"300px");

		return chart;

	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.DATE, "Date");
		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "User Tasks");
		data.addColumn(ColumnType.NUMBER, "Business Tasks");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");
	}

	private static void setRows(DataTable data,
			ArrayList<Performance> arrayDates) {

		data.addRows(arrayDates.size());

		for (int i = 0; i < arrayDates.size(); i++) {

			Performance date = arrayDates.get(i);

			data.setValue(i, 0, date.getDate());
			data.setValue(i, 1, date.getToDoCounts());
			data.setValue(i, 2, date.getUserTaskCounts());
			data.setValue(i, 3, date.getBusinessTaskCounts());
			data.setValue(i, 4, date.getClassesCounts());
			data.setValue(i, 5, date.getStepsCounts());
		}
	}
}
