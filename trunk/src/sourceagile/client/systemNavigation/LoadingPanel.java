package sourceagile.client.systemNavigation;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoadingPanel extends VerticalPanel {

	public LoadingPanel() {

		setSpacing(30);
		
		add(new Image("images/loading.gif"));
	}

}
