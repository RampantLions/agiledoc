package sourceagile.testing.client;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class NoTestFoundPanel extends VerticalPanel {

	public NoTestFoundPanel(ClassFile entry) {

		this.setSpacing(30);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Label label = new Label("No test created.");

		this.add(label);

		this.add(new ButtonCreateNewTestClass(entry));
	}

}
