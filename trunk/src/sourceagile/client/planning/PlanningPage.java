package sourceagile.client.planning;

import sourceagile.client.SystemStart;
import sourceagile.client.planning.newTask.AddTask;
import sourceagile.shared.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PlanningPage extends VerticalPanel {

	public PlanningPage(ClassFile[] entries) {

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp1.add(buttonNewFeature());

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.add(new PlanningList(entries));

		vp.add(vp1);

		this.add(vp);
	}

	public static Button buttonNewFeature() {

		Button button = new Button("Create a New Task", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent
						.add(new AddTask());

			}
		});

		return button;
	}
}