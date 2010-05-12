package com.agiledoc.client.view.todo;

import java.util.List;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Tag;
import com.agiledoc.shared.model.TodoClasse;
import com.google.gwt.user.client.ui.FlexTable;

public class ToDoList extends FlexTable {

	public ToDoList() {

		setBorderWidth(1);
		setCellPadding(4);
		setWidth("900");

		gridColumns(this);

		gridRows(this);
	}

	public static void gridColumns(FlexTable grid) {

		grid.setHTML(0, 0, "<B>Priority</B>");
		grid.getColumnFormatter().setWidth(0, "50");

		grid.setHTML(0, 1, "<B>Task Name</B>");
		grid.getColumnFormatter().setWidth(1, "200");

		grid.setHTML(0, 2, "<B>Description</B>");		
		
		grid.setHTML(0, 3, "<B>Date</B>");
		grid.getColumnFormatter().setWidth(3, "200");		
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
				grid.setText(row, 2, classe.getDescription());
				grid.setText(row, 3, classe.getDateModified().toString());
			}
		}
	}

}
