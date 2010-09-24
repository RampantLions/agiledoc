package sourceagile.client.productivity;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Productivity;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;

/**
 * @feature
 */
public class CurrentProductivityColumnsChart extends VerticalPanel {

	public CurrentProductivityColumnsChart() {

		Options options = Options.create();
		options.setHeight(240);
		// options.setTitle("Cumulative Activity");
		options.setWidth(800);
		options.set3D(true);
		options.setShowCategories(true);
		options.setEnableTooltip(true);

		DataTable data = DataTable.create();

		setColumns(data);

		if (ProjectInitialization.projectTotals == null) {

			countActivity();
		}

		setRows(data);

		ColumnChart chart = new ColumnChart(data, options);

		this.add(chart);
	}

	private void countActivity() {

		ProjectInitialization.projectTotals = new Productivity();

		for (ClassFile entry : ProjectInitialization.projectEntries) {

			ProjectInitialization.projectTotals
					.setStepsCount(ProjectInitialization.projectTotals
							.getStepsCount()
							+ entry.getClassDoc().getMethods().length);

			if (entry.getClassDoc().isTodo()) {

				ProjectInitialization.projectTotals
						.setToDoCount(ProjectInitialization.projectTotals
								.getToDoCount() + 1);
			}
		}

		ProjectInitialization.projectTotals
				.setClassesCount(ProjectInitialization.projectTotals
						.getClassesCount()
						+ ProjectInitialization.projectEntries.length);
	}

	private static void setRows(DataTable data) {

		data.addRows(1);

		data.setValue(0, 0, ProjectInitialization.projectTotals.getToDoCount());
		data.setValue(0, 1,
				ProjectInitialization.projectTotals.getFeatureCount());
		data.setValue(0, 2,
				ProjectInitialization.projectTotals.getClassesCount());
		data.setValue(0, 3, ProjectInitialization.projectTotals.getStepsCount());
	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "Features");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Steps");
	}

}
