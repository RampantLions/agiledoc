package sourceagile.planning.client.projectBacklog;

import sourceagile.client.SystemStart;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * 
 * @feature
 */
public class ProjectBacklogList extends FlexTable {

	public ProjectBacklogList() {

		setBorderWidth(1);
		setWidth("900px");

		setCellPadding(5);

		gridColumns();

		gridRows();
	}

	private void gridColumns() {

		this.setHTML(0, 0, "<B>Name</B>");
		this.getColumnFormatter().setWidth(0, "200px");

		this.setHTML(0, 1, "<B>Description</B>");
		this.getColumnFormatter().setWidth(1, "450px");

		this.setHTML(0, 2, "<B>Created</B>");
		this.getColumnFormatter().setWidth(2, "150px");

		this.setHTML(0, 3, "<B>Priority</B>");
		this.getColumnFormatter().setWidth(3, "50px");

		this.setHTML(0, 4, "<B>Estimative</B>");
		this.getColumnFormatter().setWidth(4, "50px");

		this.setHTML(0, 5, "<B>Status</B>");
		this.getColumnFormatter().setWidth(5, "50px");

		this.setHTML(0, 6, " ");
		this.getColumnFormatter().setWidth(6, "50px");
	}

	private void gridRows() {

		int row = 0;
		for (ProjectBacklog backlogEntry : ProjectInitialization.currentProject
				.getProjectBacklog()) {

			row++;

			this.setText(row, 0, backlogEntry.getBacklogName());
			this.setText(row, 1, backlogEntry.getBacklogDescription());
			this.setText(row, 2, backlogEntry.getBacklogDate().toString());

			String priority = "";
			if (backlogEntry.getBacklogPriority() != null) {
				priority = backlogEntry.getBacklogPriority().toString();
			}
			this.setText(row, 3, priority);

			String estimative = "";
			if (backlogEntry.getBacklogEstimative() != null) {
				estimative = backlogEntry.getBacklogEstimative().toString();
			}
			this.setText(row, 4, estimative);

			this.setText(row, 5, backlogEntry.getBacklogStatus());

			HorizontalPanel hp = new HorizontalPanel();
			hp.setSpacing(10);
			hp.add(iconEdit(backlogEntry));
			hp.add(iconDelete(backlogEntry));

			this.setWidget(row, 6, hp);

		}
	}

	private static Image iconEdit(final ProjectBacklog projectBacklog) {

		Image img = new Image("images/edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent
						.add(new Story(projectBacklog));
			}
		});

		img.setTitle("Edit Project Backlog");

		return img;
	}

	private static Image iconDelete(final ProjectBacklog backlogEntry) {

		Image img = new Image("images/delete.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// new EditFeatureDescription(classe);
			}
		});

		img.setTitle("Delete Project Backlog");

		return img;
	}

}
