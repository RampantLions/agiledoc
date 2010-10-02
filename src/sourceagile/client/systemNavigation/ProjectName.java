package sourceagile.client.systemNavigation;

import sourceagile.client.project.ProjectInitialization;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectName extends VerticalPanel {

	public ProjectName() {

		setSize("150px", "70px");
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		add(new HTML("<b>" + ProjectInitialization.currentProject.getName()
				+ "</b><br> Project"));
	}

}
