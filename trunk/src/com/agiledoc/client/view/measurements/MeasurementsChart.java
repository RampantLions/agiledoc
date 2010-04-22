package com.agiledoc.client.view.measurements;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.MeasurementsConvert;
import com.agiledoc.shared.model.Measurement;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.Options;

public class MeasurementsChart {

	public static AnnotatedTimeLine getChart() {

		int year, month, day;

		Options options = Options.create();
		options.setDisplayAnnotations(true);

		DataTable data = DataTable.create();
		data.addColumn(ColumnType.DATE, "Date");
		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "User Tasks");
		data.addColumn(ColumnType.NUMBER, "Business Tasks");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");

		if (GlobalVariables.getMeasurements() == null
				|| GlobalVariables.getMeasurements().size() == 0) {

			GlobalVariables.setMeasurements(MeasurementsConvert
					.getMeasurement());
		}

		data.addRows(GlobalVariables.getMeasurements().size());

		for (int i = 0; i < GlobalVariables.getMeasurements().size(); i++) {

			Measurement date = GlobalVariables.getMeasurements().get(i);

			data.setValue(i, 0, date.getDate());
			data.setValue(i, 1, date.getToDoCounts());
			data.setValue(i, 2, date.getUserTaskCounts());
			data.setValue(i, 3, date.getBusinessTaskCounts());
			data.setValue(i, 4, date.getClassesCounts());
			data.setValue(i, 5, date.getStepsCounts());
		}

		AnnotatedTimeLine chart = new AnnotatedTimeLine(data, options, "800px",
				"300px");

		return chart;

	}
}
