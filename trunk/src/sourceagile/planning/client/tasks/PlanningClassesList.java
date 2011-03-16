package sourceagile.planning.client.tasks;

import java.util.HashMap;

import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;

/**
 * List all the classes assigned as "To Do" in the current project. Enable
 * stakeholders to easily identify pending requirements straight in the source
 * code in a very precise way.
 * 
 * @MainFeature
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
	}

	private void gridRows(HashMap<String, ClassFile> entries) {

		if (entries != null) {

			int row = 0;
			for (ClassFile entry : entries.values()) {

				if (entry.getClassDoc() != null
						&& entry.getClassDoc().getClassStatus() != null) {

					row++;

					this.setWidget(row, 0, getName(entry));
					this.setText(row, 1, entry.getClassDoc().getDescription());
					this.setText(row, 2, entry.getDateModified().toString());
				}
			}
		}
	}

	private HTML getName(final ClassFile entry) {

		HTML htmlName = new HTML("<a href=#>"
				+ entry.getFeature().getFeatureName() + "</a>");

		htmlName.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new Development(entry, OptionsIcons.OPTION_DESCRIPTION);
			}
		});

		return htmlName;
	}
}
