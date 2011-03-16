package sourceagile.planning.client.tasks.taskBoard;

import java.util.HashMap;

import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @MainFeature
 */
public class TaskBoard extends VerticalPanel {

	private VerticalPanel vpNotStarted = new VerticalPanel();
	private VerticalPanel vpInProgress = new VerticalPanel();
	private VerticalPanel vpDone = new VerticalPanel();
	private VerticalPanel vpBlocked = new VerticalPanel();

	public TaskBoard(HashMap<String, ClassFile> entries) {

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setSpacing(30);

		HorizontalPanel hpBoard = new HorizontalPanel();

		vpNotStarted.setSpacing(15);
		vpNotStarted.setWidth("250px");
		vpNotStarted.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		vpNotStarted
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpNotStarted.add(new HTML("<B>Not Started</B>"));
		hpBoard.add(vpNotStarted);

		VerticalPanel vpSeparation1 = new VerticalPanel();
		vpSeparation1.setHeight("500px");
		vpSeparation1.setStyleName("taskBoard");
		hpBoard.add(vpSeparation1);

		vpInProgress.setSpacing(15);
		vpInProgress.setWidth("250px");
		vpInProgress.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		vpInProgress
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpInProgress.add(new HTML("<B>In Progress</B>"));
		hpBoard.add(vpInProgress);

		VerticalPanel vpSeparation2 = new VerticalPanel();
		vpSeparation2.setHeight("500px");
		vpSeparation2.setStyleName("taskBoard");
		hpBoard.add(vpSeparation2);

		vpDone.setSpacing(15);
		vpDone.setWidth("250px");
		vpDone.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		vpDone.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpDone.add(new HTML("<B>Done</B>"));
		hpBoard.add(vpDone);

		VerticalPanel vpSeparation3 = new VerticalPanel();
		vpSeparation3.setHeight("500px");
		vpSeparation3.setStyleName("taskBoard");
		hpBoard.add(vpSeparation3);

		vpBlocked.setSpacing(15);
		vpBlocked.setWidth("250px");
		vpBlocked.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		vpBlocked.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpBlocked.add(new HTML("<B>Blocked</B>"));
		hpBoard.add(vpBlocked);

		showTasks(entries);

		this.add(hpBoard);
	}

	private void showTasks(HashMap<String, ClassFile> entries) {

		for (ClassFile entry : entries.values()) {

			if (entry.getClassDoc() != null) {

				if (ClassDocumentation.TODO_STATUS.equals(entry.getClassDoc()
						.getClassStatus())) {

					vpNotStarted.add(getDescription(entry));

				} else if (ClassDocumentation.INPROGRESS_STATUS.equals(entry
						.getClassDoc().getClassStatus())) {

					vpInProgress.add(getDescription(entry));

				} else if (ClassDocumentation.REQUIREMENT_TAG.equals(entry
						.getClassDoc().getTagType())
						|| ClassDocumentation.MAIN_FEATURE_TAG.equals(entry
								.getClassDoc().getTagType())) {

					vpDone.add(getDescription(entry));

				} else if (ClassDocumentation.BLOCKED_STATUS.equals(entry
						.getClassDoc().getClassStatus())) {

					vpBlocked.add(getDescription(entry));
				}
			}
		}
	}

	private VerticalPanel getDescription(final ClassFile entry) {

		VerticalPanel vp = new VerticalPanel();

		vp.setBorderWidth(1);

		VerticalPanel vpIn = new VerticalPanel();

		vpIn.setSpacing(5);

		HTML htmlName = new HTML("<font size=1><a href=#>"
				+ entry.getClassDoc().getDescription() + "</a></font>");

		htmlName.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new Development(entry, OptionsIcons.OPTION_DESCRIPTION);
			}
		});

		vpIn.add(htmlName);

		vp.add(vpIn);

		return vp;
	}
}
