package sourceagile.client.activity;

import java.util.ArrayList;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.Entry;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.Options;

public class ActivityTimelineChart extends VerticalPanel {

	public ActivityTimelineChart() {

		if (ProjectInitialization.projectActivity == null) {

			ProjectInitialization.projectActivity = countActivity(ProjectInitialization.projectEntries);
		}

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
	}

	private static void setRows(DataTable data, ArrayList<Activity> arrayDates) {

		data.addRows(arrayDates.size());

		for (int i = 0; i < arrayDates.size(); i++) {

			Activity date = arrayDates.get(i);

			data.setValue(i, 0, date.getDate());
			data.setValue(i, 1, date.getToDoCounts());
			data.setValue(i, 2, date.getFeatureCounts());
			data.setValue(i, 3, date.getClassesCounts());
			data.setValue(i, 4, date.getStepsCounts());
		}
	}

	private ArrayList<Activity> countActivity(Entry[] entries) {

		ArrayList<Activity> datesActivity = new ArrayList<Activity>();

		Activity totals = new Activity();

		for (Entry entry : entries) {

			Activity currentActivity = null;
			int i;
			for (i = 0; i < datesActivity.size(); i++) {

				Activity dateActivity = datesActivity.get(i);

				if (DateTimeFormat
						.getShortDateFormat()
						.format(entry.getDateModified())
						.equals(DateTimeFormat.getShortDateFormat().format(
								dateActivity.getDate()))) {

					currentActivity = dateActivity;
					break;
				}
			}
			if (currentActivity == null) {

				currentActivity = new Activity();
				currentActivity.setDate(entry.getDateModified());
			}

			if (entry.getClassDoc().isTodo()) {

				currentActivity
						.setToDoCounts(currentActivity.getToDoCounts() + 1);

				totals.setToDoCounts(totals.getToDoCounts() + 1);
			}

			/*
			 * if (entry.getPack().getFullName().contains(
			 * GlobalVariables.getProject().getFeatureFullPackage())) {
			 * 
			 * currentActivity.setFeatureCounts(currentActivity
			 * .getFeatureCounts() + 1);
			 * 
			 * totals.setFeatureCounts(totals.getFeatureCounts() + 1);
			 * 
			 * }
			 */

			currentActivity
					.setClassesCounts(currentActivity.getClassesCounts() + 1);

			currentActivity.setStepsCounts(currentActivity.getStepsCounts()
					+ entry.getClassDoc().getConstructors().length
					+ entry.getClassDoc().getMethods().length);

			totals.setClassesCounts(totals.getClassesCounts() + 1);

			totals.setStepsCounts(totals.getStepsCounts()
					+ entry.getClassDoc().getConstructors().length
					+ entry.getClassDoc().getMethods().length);

			if (datesActivity.size() <= i) {

				datesActivity.add(currentActivity);

			} else {

				datesActivity.set(i, currentActivity);
			}
		}

		// GlobalVariables.getProject().setCumulativeProductivity(totals);

		return datesActivity;
	}
}
