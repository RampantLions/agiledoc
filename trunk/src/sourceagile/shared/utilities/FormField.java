package sourceagile.shared.utilities;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FormField extends HorizontalPanel {

	public FormField(String label, Widget field) {

		this(label, "150px", field);
	}

	public FormField(String label, String labelSize, Widget field) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label title = new Label(label + ": ");
		title.setWidth(labelSize);
		this.add(title);

		this.add(field);
	}
}
