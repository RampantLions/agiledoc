package sourceagile.client.productivity;

import java.util.ArrayList;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.Productivity;

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

		this.add(chart);
	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.DATE, "Date");
		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "Features");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");
		data.addColumn(ColumnType.NUMBER, "Activity");
	}

	private static void setRows(DataTable data,
			ArrayList<Productivity> arrayDates) {

		data.addRows(arrayDates.size());

		for (int i = 0; i < arrayDates.size(); i++) {

			Productivity date = arrayDates.get(i);

			data.setValue(i, 0, date.getDate());
			data.setValue(i, 1, date.getToDoCount());
			data.setValue(i, 2, date.getFeatureCount());
			data.setValue(i, 3, date.getClassesCount());
			data.setValue(i, 4, date.getStepsCount());
			data.setValue(i, 5, date.getClassActivityCount());
		}
	}

}
