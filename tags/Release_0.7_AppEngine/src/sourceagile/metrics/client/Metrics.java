package sourceagile.metrics.client;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @Feature
 */
public class Metrics extends VerticalPanel {

	public static VerticalPanel vpMetricsChart = new VerticalPanel();

	public static final String OPTION_TOTALS_CHART = "totalsChart";

	public Metrics() {

		this(null);
	}

	public Metrics(String chartOption) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSize("97%", "100%");

		vpMetricsChart.setSize("100%", "100%");
		vpMetricsChart.setSpacing(30);
		vpMetricsChart
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(new MetricsOptions());

		vp.add(vpMetricsChart);

		openDocumentationOption(chartOption);

		this.add(vp);
	}

	private void openDocumentationOption(String chartOption) {

		MetricsOptions.untoggleOptions();
		vpMetricsChart.clear();

		if (chartOption != null && chartOption.equals(OPTION_TOTALS_CHART)) {

			MetricsOptions.radioTotals.setValue(true);

			vpMetricsChart.add(new CurrentProductivityColumnsChart());

		} else {

			MetricsOptions.radioProductivity.setValue(true);

			vpMetricsChart.add(new ProductivityTimelineChart());
		}

	}

}
