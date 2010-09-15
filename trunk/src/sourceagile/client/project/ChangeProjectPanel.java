package sourceagile.client.project;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeProjectPanel extends DialogBox {

	public ChangeProjectPanel() {

		this.setText("Change Current Project");
		
		this.setAutoHideEnabled(true);
		this.setGlassEnabled(true);
		this.setAnimationEnabled(true);

		VerticalPanel dialogContents = new VerticalPanel();
		dialogContents.setSpacing(10);

		dialogContents.add(new HTML(
				"<B>Select a Project on the list bellow: </B>"));

		dialogContents.add(new ProjectListSelection());

		dialogContents.add(new ProjectForm());

		this.setWidget(dialogContents);
	}

}
