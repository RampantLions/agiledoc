package com.agiledoc.client.control;

import java.util.ArrayList;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Measurement;
import com.agiledoc.shared.model.Tag;

public class MeasurementsConvert {

	public static ArrayList<Measurement> getMeasurement() {

		ArrayList<Measurement> dates = new ArrayList<Measurement>();

		for (final Classe classe : GlobalVariables.getCLASSES_LIST()) {

			Measurement classeMeasurement = null;
			int i;
			for (i = 0; i < dates.size(); i++) {

				Measurement date = dates.get(i);

				if (GlobalVariables.dayFormat.format(classe.getDateModified())
						.equals(
								GlobalVariables.dayFormat
										.format(date.getDate()))) {

					classeMeasurement = date;
					break;
				}
			}
			if (classeMeasurement == null) {

				classeMeasurement = new Measurement();
				classeMeasurement.setDate(classe.getDateModified());
			}

			if (Tag.TODO.equals(classe.getTask())) {

				classeMeasurement.setToDoCounts(classeMeasurement
						.getToDoCounts() + 1);

			} else if (Tag.USER_TASK.equals(classe.getTask())) {

				classeMeasurement.setUserTaskCounts(classeMeasurement
						.getUserTaskCounts() + 1);
				classeMeasurement.setBusinessTaskCounts(classeMeasurement
						.getBusinessTaskCounts() + 1);

			} else if (Tag.TASK.equals(classe.getTask())) {

				classeMeasurement.setBusinessTaskCounts(classeMeasurement
						.getBusinessTaskCounts() + 1);
			}

			classeMeasurement.setClassesCounts(classeMeasurement
					.getClassesCounts() + 1);

			if (dates.size() <= i) {

				dates.add(classeMeasurement);

			} else {

				dates.set(i, classeMeasurement);
			}
		}

		return dates;

	}
}
