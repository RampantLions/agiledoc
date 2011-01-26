package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * 
 * @UserManual
 */
public class ProjectSelectionPanel extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static ProjectList projectList;

	public ProjectSelectionPanel(List<Project> projects) {

		this.setSpacing(20);

		projectList = new ProjectList(projects);
		this.add(new FormField(internationalizationConstants.selectAProject(),
				projectList));

	}
}
