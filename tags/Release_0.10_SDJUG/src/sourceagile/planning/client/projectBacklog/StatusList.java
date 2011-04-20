package sourceagile.planning.client.projectBacklog;

import sourceagile.shared.entities.project.ProjectBacklog;

import com.google.gwt.user.client.ui.ListBox;

public class StatusList extends ListBox {

	public StatusList(String status) {

		this.setWidth("100px");

		this.addItem(ProjectBacklog.STATUS_STANDBY);
		this.addItem(ProjectBacklog.STATUS_DEVELOPING);
		this.addItem(ProjectBacklog.STATUS_DONE);
		this.addItem(ProjectBacklog.STATUS_DISCARDED);

		if (ProjectBacklog.STATUS_STANDBY.equals(status)) {

			this.setSelectedIndex(0);

		} else if (ProjectBacklog.STATUS_DEVELOPING.equals(status)) {

			this.setSelectedIndex(1);

		} else if (ProjectBacklog.STATUS_DONE.equals(status)) {

			this.setSelectedIndex(2);

		} else if (ProjectBacklog.STATUS_DISCARDED.equals(status)) {

			this.setSelectedIndex(3);
		}
	}
}
