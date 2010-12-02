package sourceagile.documentation.client;

import sourceagile.client.SystemStart;
import sourceagile.documentation.client.classViewOptions.OptionsIcons;
import sourceagile.documentation.client.classesList.ClassesListFiltered;
import sourceagile.documentation.client.features.FeaturesList;
import sourceagile.documentation.client.serverCalls.fileExporter.FileExporter;
import sourceagile.documentation.client.specification.Specification;
import sourceagile.documentation.client.specification.SpecificationList;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.utilities.FileNameGenerator;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Documentation {

	public VerticalPanel documentationMenu = new VerticalPanel();
	public static VerticalPanel documentationPanel = new VerticalPanel();

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

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(20);

		Anchor linkAllClasses = new Anchor("All Classes");
		linkAllClasses.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new Specification(OptionsIcons.OPTION_ALLCLASSES);
			}
		});
		vp.add(linkAllClasses);

		Anchor linkFeaturesList = new Anchor("Features List");
		linkFeaturesList.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				documentationPanel.clear();
				documentationPanel.add(new FeaturesList(
						ProjectInitialization.projectEntries));
			}
		});
		vp.add(linkFeaturesList);

		Anchor linkSpecification = new Anchor("Specification");
		linkSpecification.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				documentationPanel.clear();
				documentationPanel.add(new SpecificationList(
						ProjectInitialization.projectEntries));
			}
		});
		vp.add(linkSpecification);

		Anchor linkUserManual = new Anchor("User Manual");
		linkUserManual.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				documentationPanel.clear();
				documentationPanel.add(new UserManual(
						ProjectInitialization.projectEntries));
			}
		});
		vp.add(linkUserManual);

		Anchor linkArchitecture = new Anchor("Architecture");
		linkArchitecture.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				documentationPanel.clear();
				documentationPanel.add(new ClassesListFiltered(
						ProjectInitialization.projectEntries,
						ClassDocumentation.ARCHITECTURE_TAG));
			}
		});
		vp.add(linkArchitecture);

		Anchor linkEntities = new Anchor("Entities");
		linkEntities.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				documentationPanel.clear();
				documentationPanel.add(new ClassesListFiltered(
						ProjectInitialization.projectEntries,
						ClassDocumentation.ENTITY_TAG));
			}
		});
		vp.add(linkEntities);

		Anchor linkExportXML = new Anchor("Export XML");
		linkExportXML.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();

				String fileContent = ExportXML.getEntriesXML();

				if (fileContent.length() < 100000) {

					Documentation.documentationPanel.add(ExportXML
							.getSyntaxPanel(fileContent,
									"Specification XML format"));
				}

				String fileName = FileNameGenerator
						.compactName(ProjectInitialization.currentProject
								.getName())
						+ "_Specification.xml";

				new FileExporter(fileName, fileContent);
			}
		});
		vp.add(linkExportXML);

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
