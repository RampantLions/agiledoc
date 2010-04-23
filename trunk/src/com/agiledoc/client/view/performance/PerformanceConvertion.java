package com.agiledoc.client.view.performance;

import java.util.ArrayList;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Tag;
import com.google.gwt.i18n.client.DateTimeFormat;

public class PerformanceConvertion {

	public static void count() {

		ArrayList<Performance> dates = new ArrayList<Performance>();

		Performance totals = new Performance();

		for (final Classe classe : GlobalVariables.getCLASSES_LIST()) {

			Performance classeMeasurement = null;
			int i;
			for (i = 0; i < dates.size(); i++) {

				Performance date = dates.get(i);

				if (DateTimeFormat.getShortDateFormat().format(
						classe.getDateModified()).equals(
						DateTimeFormat.getShortDateFormat().format(
								date.getDate()))) {

					classeMeasurement = date;
					break;
				}
			}
			if (classeMeasurement == null) {

				classeMeasurement = new Performance();
				classeMeasurement.setDate(classe.getDateModified());
			}

			if (Tag.TODO.equals(classe.getTask())) {

				classeMeasurement.setToDoCounts(classeMeasurement
						.getToDoCounts() + 1);

				totals.setToDoCounts(totals.getToDoCounts() + 1);

			} else if (Tag.USER_TASK.equals(classe.getTask())) {

				classeMeasurement.setUserTaskCounts(classeMeasurement
						.getUserTaskCounts() + 1);
				classeMeasurement.setBusinessTaskCounts(classeMeasurement
						.getBusinessTaskCounts() + 1);

				totals.setUserTaskCounts(totals.getUserTaskCounts() + 1);
				totals
						.setBusinessTaskCounts(totals.getBusinessTaskCounts() + 1);

			} else if (Tag.TASK.equals(classe.getTask())) {

				classeMeasurement.setBusinessTaskCounts(classeMeasurement
						.getBusinessTaskCounts() + 1);

				totals
						.setBusinessTaskCounts(totals.getBusinessTaskCounts() + 1);
			}

			classeMeasurement.setClassesCounts(classeMeasurement
					.getClassesCounts() + 1);

			totals.setClassesCounts(totals.getClassesCounts() + 1);

			if (dates.size() <= i) {

				dates.add(classeMeasurement);

			} else {

				dates.set(i, classeMeasurement);
			}
		}

		GlobalVariables.setProgressivePerformance(dates);

		GlobalVariables.setCumulativePerformance(totals);
	}
}
