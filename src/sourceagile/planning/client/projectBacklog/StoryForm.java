package sourceagile.planning.client.projectBacklog;

import java.util.Date;

import sourceagile.planning.client.serverCalls.CreateProjectBacklog;
import sourceagile.planning.client.serverCalls.UpdateProjectBacklog;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class StoryForm extends VerticalPanel {

	private TextBox storyName = new TextBox();
	private TextArea storyDescription = new TextArea();
	private TextBox storyPriority = new TextBox();
	private TextBox storyEstimative = new TextBox();
	private TextBox storyStatus = new TextBox();

	public StoryForm(ProjectBacklog projectBacklog) {

		Label space = new Label(" ");
		space.setHeight("50px");
		this.add(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		vp.add(storyForm(projectBacklog));

		this.add(vp);
	}

	public VerticalPanel storyForm(ProjectBacklog projectBacklog) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(20);

		HTML title = new HTML("<B>Enter the new story below: </B>");
		vp.add(title);

		storyName.setWidth("500px");
		storyName.setValue(projectBacklog.getBacklogName());
		vp.add(new FormField("Story Name", storyName));

		storyDescription.setSize("700px", "80px");
		storyDescription.setValue(projectBacklog.getBacklogDescription());
		vp.add(new FormField("Description", storyDescription));

		String priority = null;
		if (projectBacklog.getBacklogPriority() != null) {

			priority = projectBacklog.getBacklogPriority().toString();
		}

		storyPriority.setWidth("50px");
		storyPriority.setValue(priority);
		vp.add(new FormField("Priority", storyPriority));

		String estimative = null;
		if (projectBacklog.getBacklogEstimative() != null) {

			estimative = projectBacklog.getBacklogEstimative().toString();
		}

		storyEstimative.setWidth("50px");
		storyEstimative.setValue(estimative);
		vp.add(new FormField("Estimative", storyEstimative));

		storyStatus.setWidth("100px");
		storyStatus.setValue(projectBacklog.getBacklogStatus());
		vp.add(new FormField("Status", storyStatus));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp.add(saveButton(projectBacklog));

		return vp;
	}

	private Button saveButton(final ProjectBacklog projectBacklog) {

		Button button = new Button("Save",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				getProjectBacklog(projectBacklog);

				if (projectBacklog.getProjectBacklogID() == null) {

					new CreateProjectBacklog(projectBacklog);

				} else {

					new UpdateProjectBacklog(projectBacklog);
				}
			}
		});

		return button;
	}

	private ProjectBacklog getProjectBacklog(ProjectBacklog projectBacklog) {

		projectBacklog.setBacklogName(storyName.getValue());

		projectBacklog.setBacklogDescription(storyDescription.getValue());

		if (storyPriority.getValue() != null
				&& storyPriority.getValue().length() > 0) {

			projectBacklog.setBacklogPriority(new Integer(storyPriority
					.getValue()));
		}

		if (storyEstimative.getValue() != null
				&& storyEstimative.getValue().length() > 0) {

			projectBacklog.setBacklogEstimative(new Integer(storyEstimative
					.getValue()));
		}

		projectBacklog.setBacklogStatus(storyStatus.getValue());

		projectBacklog.setBacklogDate(new Date());

		return projectBacklog;
	}
}
