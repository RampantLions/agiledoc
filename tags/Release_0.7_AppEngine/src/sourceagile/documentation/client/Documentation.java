package sourceagile.documentation.client;

import helpagile.client.exportation.HelpWindow;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.ProjectInitialization;
import sourceagile.documentation.client.documentationMenu.ArchitectureLink;
import sourceagile.documentation.client.documentationMenu.EntitiesLink;
import sourceagile.documentation.client.documentationMenu.ExportPdfLink;
import sourceagile.documentation.client.documentationMenu.ExportXmlLink;
import sourceagile.documentation.client.documentationMenu.FeaturesListLink;
import sourceagile.documentation.client.documentationMenu.ProjectDescriptionLink;
import sourceagile.documentation.client.documentationMenu.RelatedLinksLink;
import sourceagile.shared.utilities.FileNameGenerator;

import com.google.gwt.core.client.GWT;
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

		GlobalVariables.mainPage.panelContent.clear();

		VerticalPanel vp = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();

		documentationMenu.clear();
		documentationMenu.setSize("300px", "100%");

		hp.add(documentationMenu);

		documentationMenu.add(showDocumentationMenu());

		documentationPanel.clear();
		hp.add(documentationPanel);

		vp.add(hp);

		GlobalVariables.mainPage.panelContent.add(vp);
	}

	private VerticalPanel showDocumentationMenu() {

		final String projectName = FileNameGenerator
				.compactName(ProjectInitialization.currentProject.getName());

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(20);

		vp.add(new ProjectDescriptionLink());

		vp.add(new FeaturesListLink());

		vp.add(new ArchitectureLink());

		vp.add(new EntitiesLink());

		vp.add(HelpWindow.helpLink(projectName, "true",
				internationalizationConstants.specification()));

		vp.add(HelpWindow.helpLink(projectName, "false",
				internationalizationConstants.userManual()));

		vp.add(new ExportXmlLink());

		vp.add(new ExportPdfLink());

		vp.add(new RelatedLinksLink());

		return vp;
	}
}
