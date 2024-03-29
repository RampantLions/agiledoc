package sourceagile.metrics.client;

import java.util.ArrayList;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.Productivity;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.Options;

/**
 * @feature
 */
public class ProductivityTimelineChart extends VerticalPanel {

	public ProductivityTimelineChart() {

		Options options = Options.create();
		options.setDisplayAnnotations(true);

		DataTable data = DataTable.create();

		setColumns(data);

		setRows(data, ProjectInitialization.projectActivity);

		AnnotatedTimeLine chart = new AnnotatedTimeLine(data, options, "800px",
				"300px");

		chart.setTitle("Productivity");

		this.add(chart);
	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.DATE, "Date");
		data.addColumn(ColumnType.NUMBER, "Total Classes");
		data.addColumn(ColumnType.NUMBER, "Productivity");
		// data.addColumn(ColumnType.NUMBER, "To Do");
		// data.addColumn(ColumnType.NUMBER, "Features");
		// data.addColumn(ColumnType.NUMBER, "Steps");
	}

	private static void setRows(DataTable data,
			ArrayList<Productivity> arrayDates) {

		data.addRows(arrayDates.size());

		int totalClasses = 0;
		int totalActivity = 0;

		for (int i = 0; i < arrayDates.size(); i++) {

			Productivity date = arrayDates.get(i);

			data.setValue(i, 0, date.getDate());

			totalClasses += date.getClassesCount();
			data.setValue(i, 1, totalClasses);

			totalActivity += date.getClassActivityCount();
			data.setValue(i, 2, totalActivity);

			// data.setValue(i, 3, date.getToDoCount());
			// data.setValue(i, 4, date.getFeatureCount());
			// data.setValue(i, 5, date.getStepsCount());
		}
	}

}
