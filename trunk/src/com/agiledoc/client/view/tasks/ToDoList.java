package com.agiledoc.client.view.tasks;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Tag;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * 
 * @todo
 * 
 * @author allineo
 * @modified 14/19/2010
 */
public class ToDoList {

	/**
	 * @author allineo
	 * @modified 14/19/2010
	 */
	public static FlexTable showGrid() {

		FlexTable grid = new FlexTable();
		grid.setBorderWidth(1);

		createHeader(grid);

		int row = 0;
		for (int r = 0; r < GlobalVariables.getCLASSES_LIST().length; r++) {

			Classe classe = GlobalVariables.getCLASSES_LIST()[r];

			if (Tag.TODO.equals(classe.getTask())) {

				row++;

				grid.setText(row, 0, "");
				grid.setText(row, 1, classe.getName());
				grid.setText(row, 2, classe.getDescription());
				grid.setText(row, 3, "Author");
				grid.setText(row, 4, "Date");
			}
		}

		return grid;

	}

	public static void createHeader(FlexTable grid) {

		grid.setHTML(0, 0, "<B>Priority</B>");
		grid.getColumnFormatter().setWidth(0, "50");

		grid.setHTML(0, 1, "<B>Task Name</B>");
		grid.getColumnFormatter().setWidth(1, "200");

		grid.setHTML(0, 2, "<B>Description</B>");
		grid.setHTML(0, 3, "<B>Author</B>");
		grid.setHTML(0, 4, "<B>Date</B>");
	}

}
