package com.agiledoc.client.view.todo;

import java.util.List;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Tag;
import com.agiledoc.shared.model.TodoClasse;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class ToDoList extends FlexTable {

	public ToDoList() {

		setBorderWidth(1);
		setWidth("1000");

		gridColumns(this);

		gridRows(this);
	}

	public static void gridColumns(FlexTable grid) {

		grid.setHTML(0, 0, "<B>Priority</B>");
		grid.getColumnFormatter().setWidth(0, "50");

		grid.setHTML(0, 1, "<B>Task Name</B>");
		grid.getColumnFormatter().setWidth(1, "200");

		grid.setHTML(0, 2, "<B>Description</B>");
		grid.getColumnFormatter().setWidth(2, "700");

		grid.setHTML(0, 3, "<B>Date</B>");
		grid.getColumnFormatter().setWidth(3, "260");

		grid.setHTML(0, 4, " ");
		grid.getColumnFormatter().setWidth(4, "50");
	}

	public static void gridRows(FlexTable grid) {

		List<TodoClasse> classes = GlobalVariables.getProject().getTodoList();

		int row = 0;
		for (int r = 0; r < classes.size(); r++) {

			Classe classe = classes.get(r).getClasse();

			if (Tag.TODO.equals(classe.getTask())) {

				row++;

				grid.setText(row, 0, classe.getPriority() + "");
				grid.setText(row, 1, classe.getName());
				grid.setText(row, 2, classe.getClasseDoc().getDescription());
				grid.setText(row, 3, classe.getDateModified().toString());

				HorizontalPanel hp = new HorizontalPanel();
				hp.setSpacing(10);
				hp.add(iconEditTodoFeature(classe));
				hp.add(iconDeleteTodoFeature(classe));

				grid.setWidget(row, 4, hp);
			}
		}
	}

	private static Image iconEditTodoFeature(final Classe classe) {

		Image img = new Image("img/script_edit.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new EditTodoFeature(classe);
			}
		});

		img.setTitle("Edit Feature");

		return img;
	}

	private static Image iconDeleteTodoFeature(final Classe classe) {

		Image img = new Image("img/cross.gif");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// new EditFeatureDescription(classe);
			}
		});

		img.setTitle("Delete Feature");

		return img;
	}

}
