package sourceagile.client.systemNavigation;

import helpagile.client.exportation.HelpWindow;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.ProjectInitialization;
import sourceagile.client.systemNavigation.projectMenu.ProjectMenu;
import sourceagile.documentation.client.Documentation;
import sourceagile.metrics.client.Metrics;
import sourceagile.planning.client.TodoClasses.AddTodoClass;
import sourceagile.shared.utilities.FileNameGenerator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class AboutProject extends VerticalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public AboutProject() {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(15);

		vp.add(new HTML("<font color=blue><b>About "
				+ ProjectInitialization.currentProject.getName()
				+ "</b></font><br><br>"));

		vp.add(anchorDescription());
		vp.add(anchorRelatedLinks());
		vp.add(anchorTotals());
		vp.add(anchorAddTask());
		vp.add(anchorSpecificationPortal());

		this.add(vp);
	}

	private Anchor anchorDescription() {

		Anchor projectDescription = new Anchor("Description");
		projectDescription.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProjectMenu.buttonDocumentation.toggle(true);
				new Documentation(Documentation.Option_ProjectDescription);
			}
		});

		return projectDescription;
	}

	private Anchor anchorRelatedLinks() {

		Anchor relatedLinks = new Anchor("Related Links");
		relatedLinks.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProjectMenu.buttonDocumentation.toggle(true);
				new Documentation(Documentation.Option_RelatedLinks);
			}
		});

		return relatedLinks;
	}

	private Anchor anchorTotals() {

		Anchor projectTotals = new Anchor("Totals");
		projectTotals.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProjectMenu.buttonMetrics.toggle(true);

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new Metrics(
						Metrics.OPTION_TOTALS_CHART));
			}
		});

		return projectTotals;
	}

	private Anchor anchorAddTask() {

		Anchor addTask = new Anchor("Add new task");
		addTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new AddTodoClass());
			}
		});

		return addTask;
	}

	private HTML anchorSpecificationPortal() {

		String projectName = FileNameGenerator
				.compactName(ProjectInitialization.currentProject.getName());

		HTML htmlSpecification = HelpWindow.helpLink(projectName, "true",
				internationalizationConstants.specification());

		return htmlSpecification;
	}
}
