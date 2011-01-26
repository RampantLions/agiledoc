package sourceagile.documentation.client;

import helpagile.client.exportation.HelpWindow;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.SystemStart;
import sourceagile.documentation.client.export.serverCalls.ListAllComments;
import sourceagile.documentation.client.projectDescription.ProjectDescription;
import sourceagile.shared.utilities.FileNameGenerator;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @Feature
 */
public class Documentation {

	public VerticalPanel documentationMenu = new VerticalPanel();
	public static VerticalPanel documentationPanel = new VerticalPanel();

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public Documentation() {

		SystemStart.mainPage.panelContent.clear();

		VerticalPanel vp = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();

		documentationMenu.clear();
		documentationMenu.setSize("300px", "100%");

		hp.add(documentationMenu);

		documentationMenu.add(showDocumentationMenu());

		documentationPanel.clear();
		hp.add(documentationPanel);

		vp.add(hp);

		SystemStart.mainPage.panelContent.add(vp);
	}

	private VerticalPanel showDocumentationMenu() {

		final String projectName = FileNameGenerator
				.compactName(ProjectInitialization.currentProject.getName());

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(20);

		Anchor linkProjectDescription = new Anchor(
				internationalizationConstants.projectDescription());
		linkProjectDescription.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				documentationPanel.clear();
				documentationPanel.add(new ProjectDescription());
			}
		});
		vp.add(linkProjectDescription);

		vp.add(HelpWindow.helpLink(projectName, "true",
				internationalizationConstants.specification()));

		vp.add(HelpWindow.helpLink(projectName, "false",
				internationalizationConstants.userManual()));

		Anchor linkExportXML = new Anchor(
				internationalizationConstants.export() + " XML");
		linkExportXML.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new ListAllComments();
			}
		});
		vp.add(linkExportXML);

		Anchor linkExportPDF = new Anchor(
				internationalizationConstants.export() + " PDF");
		linkExportPDF.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});
		vp.add(linkExportPDF);

		Anchor linkWiki = new Anchor("Wiki");
		linkWiki.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (ProjectInitialization.currentProject.getWiki() != null) {

					Window.open(ProjectInitialization.currentProject.getWiki(),
							"_blank", null);
				}

			}
		});
		vp.add(linkWiki);

		return vp;
	}
}
