package sourceagile.metrics.client;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.Productivity;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;

/**
 * Show a Columns Chart with the total amount of tasks, classes and methods in
 * the current project.
 * 
 * @Feature
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

		for (ClassFile entry : ProjectInitialization.projectEntries.values()) {

			int constructorsCount = 0;
			if (entry.getClassDoc() != null) {

				if (entry.getClassDoc().getConstructors() != null) {

					constructorsCount = entry.getClassDoc().getConstructors().length;
				}

				int methodsCount = 0;
				if (entry.getClassDoc().getMethods() != null) {

					methodsCount = entry.getClassDoc().getMethods().length;
				}

				ProjectInitialization.projectTotals
						.setMethodsCount(ProjectInitialization.projectTotals
								.getMethodsCount()
								+ (constructorsCount + methodsCount));

				if (entry.getClassDoc().isTodo()) {

					ProjectInitialization.projectTotals
							.setToDoCount(ProjectInitialization.projectTotals
									.getToDoCount() + 1);
				}

				if (entry.getClassDoc().getTagType() != null
						&& entry.getClassDoc().getTagType()
								.equals(ClassDocumentation.MAIN_FEATURE_TAG)) {

					ProjectInitialization.projectTotals
							.setFeatureCount(ProjectInitialization.projectTotals
									.getFeatureCount() + 1);
				}
			}
		}

		ProjectInitialization.projectTotals
				.setClassesCount(ProjectInitialization.projectTotals
						.getClassesCount()
						+ ProjectInitialization.projectEntries.size());
	}

	private static void setRows(DataTable data) {

		data.addRows(1);

		data.setValue(0, 0, ProjectInitialization.projectTotals.getToDoCount());
		data.setValue(0, 1,
				ProjectInitialization.projectTotals.getFeatureCount());
		data.setValue(0, 2,
				ProjectInitialization.projectTotals.getClassesCount());
		data.setValue(0, 3,
				ProjectInitialization.projectTotals.getMethodsCount());
	}

	private static void setColumns(DataTable data) {

		data.addColumn(ColumnType.NUMBER, "To Do");
		data.addColumn(ColumnType.NUMBER, "Features");
		data.addColumn(ColumnType.NUMBER, "Classes");
		data.addColumn(ColumnType.NUMBER, "Methods");
	}

}
