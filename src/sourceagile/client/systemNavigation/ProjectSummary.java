package sourceagile.client.systemNavigation;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 * @TODO
 */
public class ProjectSummary extends VerticalPanel {

	public ProjectSummary() {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(15);

		vp.add(new HTML("<font color=blue><b>Project Summary</b></font>"));

		Grid grid = new Grid(2, 2);

		grid.setWidth("450px");

		grid.setCellSpacing(15);

		grid.setHTML(0, 0,
				"To do: 2 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");

		grid.setText(0, 1, "Features: 3         ");

		grid.setHTML(
				1,
				0,
				"Total Files: 37 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");

		grid.setHTML(
				1,
				1,
				"Lines of Code: 4783 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");

		vp.add(grid);

		this.add(vp);
	}
}
