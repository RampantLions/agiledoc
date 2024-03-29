package sourceagile.shared.utilities;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class FormField {

	public static HorizontalPanel getFormField(String label, Widget field) {

		return getFormField(label, "150px", field);
	}

	public static HorizontalPanel getFormField(String label, String labelSize,
			Widget field) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(5);
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label title = new Label(label + ": ");
		title.setWidth(labelSize);
		hp.add(title);

		hp.add(field);

		return hp;
	}

	public static VerticalPanel getVerticalFormField(String label,
			String labelSize, Widget field) {

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(5);
		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label title = new Label(label + ": ");
		title.setWidth(labelSize);
		vp.add(title);

		vp.add(field);

		return vp;
	}
}
