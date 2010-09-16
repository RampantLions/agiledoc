package sourceagile.client.planning;

import sourceagile.shared.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class TodoList extends FlexTable {

	public TodoList(Entry[] entries) {

		setBorderWidth(1);
		setWidth("900px");

		gridColumns();

		gridRows(entries);
	}

	private void gridColumns() {

		this.setHTML(0, 0, "<B>Name</B>");
		this.getColumnFormatter().setWidth(0, "200px");

		this.setHTML(0, 1, "<B>Description</B>");
		this.getColumnFormatter().setWidth(1, "450px");

		this.setHTML(0, 2, "<B>Date</B>");
		this.getColumnFormatter().setWidth(2, "100px");

		this.setHTML(0, 3, " ");
		this.getColumnFormatter().setWidth(3, "50px");
	}

	private void gridRows(Entry[] entries) {

		int row = 0;
		for (Entry entry : entries) {

		/*	if (entry.getClassDoc().isTodo()) {

				row++;

				this.setText(row, 0, entry.getFeature().getFeatureName());
				this.setText(row, 1, entry.getClassDoc().getDescription());
				this.setText(row, 2, entry.getDateModified().toString());

				HorizontalPanel hp = new HorizontalPanel();
				hp.setSpacing(10);
				hp.add(iconEditTodoFeature(entry));
				hp.add(iconDeleteTodoFeature(entry));

				this.setWidget(row, 4, hp);
			}*/
		}
	}

	private static Image iconEditTodoFeature(final Entry entry) {

		Image img = new Image("images/edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// EditTodoFeature(classe);
			}
		});

		img.setTitle("Edit Planned Feature");

		return img;
	}

	private static Image iconDeleteTodoFeature(final Entry entry) {

		Image img = new Image("images/delete.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// new EditFeatureDescription(classe);
			}
		});

		img.setTitle("Delete Planned Feature");

		return img;
	}

}
