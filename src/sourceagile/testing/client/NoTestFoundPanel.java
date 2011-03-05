package sourceagile.testing.client;

import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class NoTestFoundPanel extends VerticalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public NoTestFoundPanel(ClassFile entry) {

		this.setSpacing(30);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Label label = new Label(internationalizationConstants.noTestCreated());

		this.add(label);

		this.add(new ButtonCreateNewTestClass(entry));
	}

}
