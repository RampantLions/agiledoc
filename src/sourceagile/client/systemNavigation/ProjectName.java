package sourceagile.client.systemNavigation;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.systemNavigation.projectMenu.ProjectMenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectName extends VerticalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ProjectName() {

		setWidth("150px");
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML html = new HTML("<a href='#'><b>"
				+ ProjectInitialization.currentProject.getName() + "</b><br> "
				+ internationalizationConstants.project() + "</a>");

		html.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// GlobalVariables.mainPage.panelContent.clear();
				// GlobalVariables.mainPage.panelContent
				// .setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				// GlobalVariables.mainPage.panelContent.add(new ProjectForm(
				// ProjectInitialization.currentProject));
				// GlobalVariables.mainPage.panelContent
				// .setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

				GlobalVariables.mainPage = new MainPage();

				ProjectMenu.untoggleButtons();

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(GlobalVariables.mainPage);
			}
		});

		add(html);

	}

}
