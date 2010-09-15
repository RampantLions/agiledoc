package sourceagile.client.systemNavigation;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WelcomePage extends VerticalPanel {

	public WelcomePage() {

		setSpacing(20);
		
		add(new Label(" "));
		
		add(new Label("Welcome to the Source Code Agile Experiment"));
	}

}
