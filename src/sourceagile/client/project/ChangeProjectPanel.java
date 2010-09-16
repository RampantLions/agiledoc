package sourceagile.client.project;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeProjectPanel extends VerticalPanel {

	public ChangeProjectPanel() {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setTitle("Change Current Project");

		vp.setSpacing(10);

		vp.add(new HTML("<B>Select a Project on the list bellow: </B>"));

		vp.add(new ProjectListSelection());

		vp.add(new ProjectForm());

		this.add(vp);
	}

}
