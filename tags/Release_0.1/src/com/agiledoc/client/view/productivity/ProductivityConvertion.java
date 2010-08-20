package com.agiledoc.client.view.productivity;

import java.util.ArrayList;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Productivity;
import com.agiledoc.shared.model.Tag;
import com.google.gwt.i18n.client.DateTimeFormat;

public class ProductivityConvertion {

	public static void count() {

		ArrayList<Productivity> dates = new ArrayList<Productivity>();

		Productivity totals = new Productivity();

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			Productivity classeMeasurement = null;
			int i;
			for (i = 0; i < dates.size(); i++) {

				Productivity date = dates.get(i);

				if (DateTimeFormat.getShortDateFormat().format(
						classe.getDateModified()).equals(
						DateTimeFormat.getShortDateFormat().format(
								date.getDate()))) {

					classeMeasurement = date;
					break;
				}
			}
			if (classeMeasurement == null) {

				classeMeasurement = new Productivity();
				classeMeasurement.setDate(classe.getDateModified());
			}

			if (Tag.TODO.equals(classe.getTask())) {

				classeMeasurement.setToDoCounts(classeMeasurement
						.getToDoCounts() + 1);

				totals.setToDoCounts(totals.getToDoCounts() + 1);
			}

			if (classe.getPack().getFullName().contains(
					GlobalVariables.getProject().getFeatureFullPackage())) {

				classeMeasurement.setFeatureCounts(classeMeasurement
						.getFeatureCounts() + 1);

				totals.setFeatureCounts(totals.getFeatureCounts() + 1);

			}

			classeMeasurement.setClassesCounts(classeMeasurement
					.getClassesCounts() + 1);

			classeMeasurement.setStepsCounts(classeMeasurement.getStepsCounts()
					+ classe.getClasseDoc().getConstructors().length
					+ classe.getClasseDoc().getMethods().length);

			totals.setClassesCounts(totals.getClassesCounts() + 1);

			totals.setStepsCounts(totals.getStepsCounts()
					+ classe.getClasseDoc().getConstructors().length
					+ classe.getClasseDoc().getMethods().length);

			if (dates.size() <= i) {

				dates.add(classeMeasurement);

			} else {

				dates.set(i, classeMeasurement);
			}
		}

		GlobalVariables.getProject().setProgressiveProductivity(dates);

		GlobalVariables.getProject().setCumulativeProductivity(totals);
	}
}
