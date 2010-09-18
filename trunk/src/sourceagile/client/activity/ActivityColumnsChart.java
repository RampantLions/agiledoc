package sourceagile.client.activity;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.Entry;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;

public class ActivityColumnsChart extends VerticalPanel {

	public static int toDoCounts = 0;

	public static int featureCounts = 0;

	public static int classesCounts = 0;

	public static int stepsCounts = 0;

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

		if (classesCounts == 0) {

			countActivity();
		}

		setRows(data);

		ColumnChart chart = new ColumnChart(data, options);

		this.add(chart);
	}

	private void countActivity() {

		for (Entry entry : ProjectInitialization.projectEntries) {

			stepsCounts = stepsCounts + entry.getClassDoc().getMethods().length;

			if (entry.getClassDoc().isTodo()) {

				toDoCounts++;
			}
		}

		classesCounts = ProjectInitialization.projectEntries.length;
	}

	private static void setRows(DataTable data) {

		data.addRows(1);

		data.setValue(0, 0, toDoCounts);
		data.setValue(0, 1, featureCounts);
		data.setValue(0, 2, classesCounts);
		data.setValue(0, 3, stepsCounts);
	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "Features");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");
	}

}
