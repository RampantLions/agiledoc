package sourceagile.planning.client;

import java.util.HashMap;

import sourceagile.client.GlobalVariables;
import sourceagile.planning.client.TodoClasses.AddTodoClass;
import sourceagile.planning.client.TodoClasses.PlanningClassesList;
import sourceagile.planning.client.projectBacklog.ProjectBacklogList;
import sourceagile.planning.client.projectBacklog.Story;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the list of planning tasks.
 * 
 * @Feature
 */
public class PlanningPage extends VerticalPanel {

	public VerticalPanel vpProjectBacklog = new VerticalPanel();

	public PlanningPage(HashMap<String, ClassFile> entries) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(10);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp1.add(buttonNewTask());

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.add(new PlanningClassesList(entries));

		vp.add(vp1);

		VerticalPanel vp2 = new VerticalPanel();
		vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp2.setSize("100%", "100%");
		vp2.setSpacing(10);

		HTML html = new HTML(
				"<br><br><br><b><font color='blue' size='3'>Project Backlog</font></b> ");
		vp2.add(html);

		vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp2.add(buttonNewStory());

		vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp2.add(new ProjectBacklogList());

		vp.add(vp2);

		this.add(vp);
	}

	private static Button buttonNewTask() {

		Button button = new Button("New Task", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new AddTodoClass());

			}
		});

		return button;
	}

	private static Button buttonNewStory() {

		Button button = new Button("New Story", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new Story(
						new ProjectBacklog()));
			}
		});

		return button;
	}
}
