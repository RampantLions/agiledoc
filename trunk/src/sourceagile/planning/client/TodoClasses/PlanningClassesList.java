package sourceagile.planning.client.TodoClasses;

import java.util.HashMap;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * List all the classes assigned as "To Do" in the current project.
 * 
 * @Feature
 */
public class PlanningClassesList extends FlexTable {

	public PlanningClassesList(HashMap<String, ClassFile> entries) {

		setBorderWidth(1);
		setWidth("900px");

		setCellPadding(5);

		gridColumns();

		gridRows(entries);
	}

	private void gridColumns() {

		this.setHTML(0, 0, "<B>Name</B>");
		this.getColumnFormatter().setWidth(0, "200px");

		this.setHTML(0, 1, "<B>Description</B>");
		this.getColumnFormatter().setWidth(1, "450px");

		this.setHTML(0, 2, "<B>Created</B>");
		this.getColumnFormatter().setWidth(2, "150px");

		this.setHTML(0, 3, " ");
		this.getColumnFormatter().setWidth(3, "50px");
	}

	private void gridRows(HashMap<String, ClassFile> entries) {

		if (entries != null) {

			int row = 0;
			for (ClassFile entry : entries.values()) {

				if (entry.getClassDoc() != null && entry.getClassDoc().isTodo()) {

					row++;

					this.setText(row, 0, entry.getFeature().getFeatureName());
					this.setText(row, 1, entry.getClassDoc().getDescription());
					this.setText(row, 2, entry.getDateModified().toString());

					HorizontalPanel hp = new HorizontalPanel();
					hp.setSpacing(10);
					hp.add(new IconViewTodoClass(entry));

					this.setWidget(row, 3, hp);
				}
			}
		}
	}
}
