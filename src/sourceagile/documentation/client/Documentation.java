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
import sourceagile.documentation.client.project.ProjectDescription;
import sourceagile.documentation.client.project.RelatedLinks;
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

	public static final String Option_ProjectDescription = "projectDescription";
	public static final String Option_RelatedLinks = "relatedLinks";

	public static ProjectDescriptionLink projectDescriptionLink = new ProjectDescriptionLink();
	public static FeaturesListLink featuresListLink = new FeaturesListLink();
	public static ArchitectureLink architectureLink = new ArchitectureLink();
	public static EntitiesLink entitiesLink = new EntitiesLink();
	public static ExportXmlLink exportXmlLink = new ExportXmlLink();
	public static ExportPdfLink exportPdfLink = new ExportPdfLink();
	public static RelatedLinksLink relatedLinksLink = new RelatedLinksLink();

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public Documentation() {

		this(null);
	}

	public Documentation(String option) {

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

		if (option != null) {

			openDocumentationOption(option);
		}
	}

	private VerticalPanel showDocumentationMenu() {

		final String projectName = FileNameGenerator
				.compactName(ProjectInitialization.currentProject.getName());

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(20);

		vp.add(projectDescriptionLink);

		vp.add(featuresListLink);

		vp.add(architectureLink);

		vp.add(entitiesLink);

		vp.add(HelpWindow.helpLink(projectName, "true",
				internationalizationConstants.specification()));

		vp.add(HelpWindow.helpLink(projectName, "false",
				internationalizationConstants.userManual()));

		vp.add(exportXmlLink);

		vp.add(exportPdfLink);

		vp.add(relatedLinksLink);

		return vp;
	}

	public static void untoggleLinks() {

		projectDescriptionLink.setHTML(ProjectDescriptionLink.textUnpressed);
		featuresListLink.setHTML(FeaturesListLink.textUnpressed);
		architectureLink.setHTML(ArchitectureLink.textUnpressed);
		entitiesLink.setHTML(EntitiesLink.textUnpressed);
		exportXmlLink.setHTML(ExportXmlLink.textUnpressed);
		exportPdfLink.setHTML(ExportPdfLink.textUnpressed);
		relatedLinksLink.setHTML(RelatedLinksLink.textUnpressed);
	}

	private void openDocumentationOption(String option) {

		if (option.equals(Option_ProjectDescription)) {

			projectDescriptionLink.setHTML(ProjectDescriptionLink.textPressed);
			documentationPanel.add(new ProjectDescription());

		} else if (option.equals(Option_RelatedLinks)) {

			relatedLinksLink.setHTML(RelatedLinksLink.textPressed);
			documentationPanel.add(new RelatedLinks());
		}

	}
}
