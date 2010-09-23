package sourceagile.client.productivity;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProductivityPage extends VerticalPanel {

	public ProductivityPage() {

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.add(new ProductivityTimelineChart());

		vp1.add(new CurrentProductivityColumnsChart());

		vp.add(vp1);

		this.add(vp);
	}
}
