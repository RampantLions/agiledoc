package com.agiledoc.client.view.tasks;

import com.google.gwt.user.client.ui.Grid;

/**
 * 
 * @todo
 * 
 * @author allineo
 * @modified 14/17/2010
 * 
 */
public class ToDoList {

	public static Grid showList() {

		Grid grid = new Grid(4, 5);
		
		grid.setBorderWidth(1);

		grid.setText(0, 0, "Priority");
		grid.setText(0, 1, "Task Name");
		grid.setText(0, 2, "Description");
		grid.setText(0, 3, "Author");
		grid.setText(0, 4, "Date");

		int numRows = grid.getRowCount();
		int numColumns = grid.getColumnCount();
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				// grid.setWidget(row, col, new
				// Image(Showcase.images.gwtLogo()));
			}
		}

		return grid;

	}
}
