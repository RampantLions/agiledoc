package sourceagile.planning.client;

import java.util.HashMap;

import sourceagile.planning.client.TodoClasses.PlanningClassesList;
import sourceagile.planning.client.serverCalls.ListProjectBacklog;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.LoadingPanel;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the list of planning tasks.
 * 
 * @Feature
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
		vp1.add(new ButtonNewTask());

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

		vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp2.add(vpProjectBacklog);

		vp.add(vp2);

		this.add(vp);

		new ListProjectBacklog();
	}
}
