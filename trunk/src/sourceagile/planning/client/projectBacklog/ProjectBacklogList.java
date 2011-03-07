package sourceagile.planning.client.projectBacklog;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * 
 * @Feature
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
		this.getColumnFormatter().setWidth(1, "250px");

		this.setHTML(0, 2, "<B>Created</B>");
		this.getColumnFormatter().setWidth(2, "150px");

		this.setHTML(0, 3, "<B>Priority</B>");
		this.getColumnFormatter().setWidth(3, "60px");

		this.setHTML(0, 4, "<B>Estimative</B>");
		this.getColumnFormatter().setWidth(4, "60px");

		this.setHTML(0, 5, "<B>Status</B>");
		this.getColumnFormatter().setWidth(5, "60px");

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

	private static HTML iconEdit(final ProjectBacklog projectBacklog) {

		HTML img = new HTML("<a href='#'><img src='images/edit.gif'></a>");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new StoryForm(
						projectBacklog));
			}
		});

		img.setTitle("Edit Project Backlog");

		return img;
	}

	private static HTML iconDelete(final ProjectBacklog backlogEntry) {

		HTML img = new HTML("<a href='#'><img src='images/delete.gif'></a>");
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
