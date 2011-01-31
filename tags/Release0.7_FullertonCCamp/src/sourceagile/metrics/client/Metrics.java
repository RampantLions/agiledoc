package sourceagile.metrics.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

/** 
 * 
 * 
 * @Feature 
 */

public class Metrics extends VerticalPanel {

	RadioButton radioProductivity = new RadioButton("Effort",
			" Effort");

	RadioButton radioVelocity = new RadioButton("Velocity", " Velocity");
	
	RadioButton radioTotals = new RadioButton("Totals", " Totals");
	
	RadioButton radioDiagnosis = new RadioButton("Diagnosis", " Diagnosis");

	final VerticalPanel vp1 = new VerticalPanel();

	public Metrics() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSize("97%", "100%");

		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(chartOptions());

		vp.add(vp1);

		radioProductivity.setValue(true);

		vp1.add(new ProductivityTimelineChart());

		this.add(vp);
	}

	private HorizontalPanel chartOptions() {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(30);

		radioProductivity.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				radioVelocity.setValue(false);
				radioTotals.setValue(false);
				radioDiagnosis.setValue(false);

				vp1.clear();

				vp1.add(new ProductivityTimelineChart());
			}
		});

		hp.add(radioProductivity);

		radioVelocity.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				radioProductivity.setValue(false);
				radioTotals.setValue(false);
				radioDiagnosis.setValue(false);

				vp1.clear();

				vp1.add(new VelocityTimelineChart());
			}
		});

		hp.add(radioVelocity);
		
		radioTotals.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				radioProductivity.setValue(false);
				radioVelocity.setValue(false);
				radioDiagnosis.setValue(false);

				vp1.clear();

				vp1.add(new CurrentProductivityColumnsChart());
			}
		});

		hp.add(radioTotals);
		
		radioDiagnosis.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				radioProductivity.setValue(false);
				radioVelocity.setValue(false);
				radioTotals.setValue(false);

				vp1.clear();
			}
		});

		hp.add(radioDiagnosis);

		return hp;
	}

}
