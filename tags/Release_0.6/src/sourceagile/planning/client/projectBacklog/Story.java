package sourceagile.planning.client.projectBacklog;

import java.util.Date;

import sourceagile.client.systemNavigation.FormField;
import sourceagile.planning.client.serverCalls.CreateProjectBacklog;
import sourceagile.shared.entities.project.ProjectBacklog;

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
 * @feature
 */
public class Story extends VerticalPanel {

	private TextBox storyName = new TextBox();
	private TextArea storyDescription = new TextArea();

	public Story(ProjectBacklog projectBacklog) {

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
		vp.setSpacing(50);

		HTML title = new HTML("<B>Enter the new story below: </B>");
		vp.add(title);

		storyName.setWidth("500px");
		storyName.setValue(projectBacklog.getBacklogName());
		vp.add(new FormField("Story Name", storyName));

		storyDescription.setSize("700px", "80px");
		storyDescription.setValue(projectBacklog.getBacklogDescription());
		vp.add(new FormField("Description", storyDescription));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp.add(saveButton());

		return vp;
	}

	private Button saveButton() {

		Button button = new Button("Save",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new CreateProjectBacklog(getProjectBacklog());
			}
		});

		return button;
	}

	private ProjectBacklog getProjectBacklog() {

		ProjectBacklog projectBacklog = new ProjectBacklog();

		projectBacklog.setBacklogName(storyName.getValue());

		projectBacklog.setBacklogDescription(storyDescription.getValue());

		projectBacklog.setBacklogDate(new Date());

		return projectBacklog;
	}
}
