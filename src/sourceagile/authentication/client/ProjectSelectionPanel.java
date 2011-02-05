package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class ProjectSelectionPanel extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static ProjectList projectList;

	public ProjectSelectionPanel(List<Project> projects) {

		if (GlobalVariables.isReadyOnly) {

			projectList = new ProjectList();

		} else {

			projectList = new ProjectList(projects);
		}

		this.add(new Label(internationalizationConstants.selectAProject()
				+ ": "));

		this.add(projectList);
	}
}
