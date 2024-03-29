package sourceagile.client.systemNavigation.projectMenu;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ProjectMenu extends HorizontalPanel {

	public static ButtonPlanning buttonPlanning = new ButtonPlanning();

	public static ButtonImplementation buttonDevelopment = new ButtonImplementation();

	public static ButtonDocumentation buttonDocumentation = new ButtonDocumentation();

	public static ButtonMetrics buttonMetrics = new ButtonMetrics();

	public ProjectMenu() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.setSpacing(5);

		this.setWidth("200px");

		this.add(buttonPlanning);

		this.add(buttonDevelopment);

		this.add(buttonDocumentation);

		this.add(buttonMetrics);
	}

	public static void untoggleButtons() {

		ProjectMenu.buttonPlanning.toggle(false);
		ProjectMenu.buttonDevelopment.toggle(false);
		ProjectMenu.buttonDocumentation.toggle(false);
		ProjectMenu.buttonMetrics.toggle(false);
	}
}
