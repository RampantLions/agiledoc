package sourceagile.metrics.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;

/**
 * 
 * @UserManual
 */
public class MetricsOptions extends HorizontalPanel {

	public static RadioButton radioProductivity = new RadioButton("Effort",
			" Effort");

	public static RadioButton radioVelocity = new RadioButton("Velocity",
			" Velocity");

	public static RadioButton radioTotals = new RadioButton("Totals", " Totals");

	public static RadioButton radioDiagnosis = new RadioButton("Diagnosis",
			" Diagnosis");

	public MetricsOptions() {

		this.setSpacing(30);

		radioProductivity.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				untoggleOptions();
				radioProductivity.setValue(true);

				Metrics.vpMetricsChart.clear();

				Metrics.vpMetricsChart.add(new ProductivityTimelineChart());
			}
		});

		this.add(radioProductivity);

		radioVelocity.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				untoggleOptions();
				radioVelocity.setValue(true);

				Metrics.vpMetricsChart.clear();

				Metrics.vpMetricsChart.add(new VelocityTimelineChart());
			}
		});

		this.add(radioVelocity);

		radioTotals.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				untoggleOptions();
				radioTotals.setValue(true);

				Metrics.vpMetricsChart.clear();

				Metrics.vpMetricsChart
						.add(new CurrentProductivityColumnsChart());
			}
		});

		this.add(radioTotals);

		radioDiagnosis.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				untoggleOptions();
				radioDiagnosis.setValue(true);

				Metrics.vpMetricsChart.clear();
			}
		});

		this.add(radioDiagnosis);
	}

	public static void untoggleOptions() {

		radioProductivity.setValue(false);
		radioVelocity.setValue(false);
		radioTotals.setValue(false);
		radioDiagnosis.setValue(false);
	}

}
