package sourceagile.client.userFeatures.productivity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProductivityPage extends VerticalPanel {

	RadioButton radioProductivity = new RadioButton("Productivity",
			" Productivity");

	RadioButton radioVelocity = new RadioButton("Velocity", " Velocity");

	final VerticalPanel vp1 = new VerticalPanel();

	public ProductivityPage() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSize("97%", "100%");

		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(chartOptions());

		vp.add(vp1);

		radioProductivity.setValue(true);

		vp1.add(new ProductivityTimelineChart());

		vp1.add(new CurrentProductivityColumnsChart());

		this.add(vp);
	}

	private HorizontalPanel chartOptions() {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(30);

		radioProductivity.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				radioVelocity.setValue(false);

				vp1.clear();

				vp1.add(new ProductivityTimelineChart());

				vp1.add(new CurrentProductivityColumnsChart());
			}
		});

		hp.add(radioProductivity);

		radioVelocity.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				radioProductivity.setValue(false);

				vp1.clear();

				vp1.add(new VelocityTimelineChart());

				vp1.add(new CurrentProductivityColumnsChart());
			}
		});

		hp.add(radioVelocity);

		return hp;
	}

}
