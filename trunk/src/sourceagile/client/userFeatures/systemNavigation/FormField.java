package sourceagile.client.userFeatures.systemNavigation;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FormField extends HorizontalPanel {

	public FormField(String label, Widget field) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label title = new Label(label + ": ");
		title.setWidth("150px");
		this.add(title);

		this.add(field);
	}
}
