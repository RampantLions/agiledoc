package sourceagile.client.userFeatures.documentation;

import sourceagile.client.SystemStart;
import sourceagile.client.userFeatures.documentation.features.FeaturesList;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.client.userFeatures.documentation.userManual.UserManual;
import sourceagile.client.userFeatures.project.ProjectInitialization;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

			}
		});
		vp.add(linkArchitecture);

		Anchor linkWiki = new Anchor("Wiki");
		linkWiki.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});
		vp.add(linkWiki);

		return vp;
	}
}
