package sourceagile.client.activity;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.Options;

public class ActivityTimelineChart extends VerticalPanel {

	public ActivityTimelineChart() {

		Options options = Options.create();
		options.setDisplayAnnotations(true);

		DataTable data = DataTable.create();

		setColumns(data);

		// setRows(data,
		// GlobalVariables.getProject().getProgressiveProductivity());

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

	/*
	 * private static void setRows(DataTable data, ArrayList<Productivity>
	 * arrayDates) {
	 * 
	 * data.addRows(arrayDates.size());
	 * 
	 * for (int i = 0; i < arrayDates.size(); i++) {
	 * 
	 * Productivity date = arrayDates.get(i);
	 * 
	 * data.setValue(i, 0, date.getDate()); data.setValue(i, 1,
	 * date.getToDoCounts()); data.setValue(i, 2, date.getFeatureCounts());
	 * data.setValue(i, 3, date.getClassesCounts()); data.setValue(i, 4,
	 * date.getStepsCounts()); } }
	 */
}
