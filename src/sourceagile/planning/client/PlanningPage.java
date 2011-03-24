package sourceagile.planning.client;

import java.util.HashMap;

import sourceagile.planning.client.projectBacklog.ButtonNewStory;
import sourceagile.planning.client.serverCalls.ListProjectBacklog;
import sourceagile.planning.client.tasks.ButtonNewTask;
import sourceagile.planning.client.tasks.PlanningClassesList;
import sourceagile.planning.client.tasks.taskBoard.TaskBoardLink;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.LoadingPanel;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the list of planning tasks.
 * 
 */
public class PlanningPage extends VerticalPanel {

	public static VerticalPanel vpProjectBacklog = new VerticalPanel();

	public PlanningPage(HashMap<String, ClassFile> entries) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(10);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HorizontalPanel hp = new HorizontalPanel();
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		hp.add(new TaskBoardLink());

		Label space = new Label(" ");
		space.setWidth("720px");
		hp.add(space);

		hp.add(new ButtonNewTask());

		vp1.add(hp);

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
		vp2.add(new ButtonNewStory());

		vpProjectBacklog.add(new LoadingPanel());
		vpProjectBacklog
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp2.add(vpProjectBacklog);

		vp.add(vp2);

		this.add(vp);

		new ListProjectBacklog();
	}
}
