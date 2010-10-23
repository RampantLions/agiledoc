package sourceagile.client.userFeatures.documentation;

import sourceagile.client.SystemStart;
import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.documentation.features.FeaturesList;
import sourceagile.client.userFeatures.documentation.specification.AllClassesSpecificationList;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.client.userFeatures.project.ProjectInitialization;

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
		documentationMenu.setSize("350px", "100%");

		hp.add(documentationMenu);

		documentationMenu.add(showDocumentationMenu());

		documentationPanel.clear();
		documentationPanel.setSpacing(20);
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

				new Specification();
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
				documentationPanel.add(new ArchitectureList(
						ProjectInitialization.projectEntries));
			}
		});
		vp.add(linkArchitecture);

		Anchor linkExportXML = new Anchor("Export XML");
		linkExportXML.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(ExportXML.getSyntaxPanel(
						ExportXML.getEntriesXML(), "Specification XML format"));

				;
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
