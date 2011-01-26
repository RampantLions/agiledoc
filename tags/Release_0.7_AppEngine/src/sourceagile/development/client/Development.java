package sourceagile.development.client;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.classesList.ComponentsList;
import sourceagile.development.client.classesList.ListFiles;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show all the classes of the current project as a specification format.
 * 
 * @Feature
 */
public class Development {

	public static VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	public Development() {

		this(null, OptionsIcons.OPTION_DESCRIPTION);
	}

	public Development(int viewOption) {

		this(null, viewOption);
	}

	public Development(ClassFile entry, int viewOption) {

		GlobalVariables.mainPage.panelContent.clear();

		VerticalPanel vp = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();

		VerticalPanel vpTree = new VerticalPanel();

		vpTree.add(showViewOptions());

		featuresTreePanel.setSize("350px", "100%");

		vpTree.add(featuresTreePanel);

		hp.add(vpTree);

		showTree(viewOption);

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		hp.add(featureVisualizationPanel);

		if (entry != null) {

			showClass(entry, viewOption);
		}

		vp.add(hp);

		GlobalVariables.mainPage.panelContent.add(vp);
	}

	private static HorizontalPanel showViewOptions() {

		HorizontalPanel optionsPanel = new HorizontalPanel();

		HTML htmlFeatures = new HTML("<font size=1>Features</font>");
		htmlFeatures.setWidth("60px");

		htmlFeatures.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				showTree(OptionsIcons.OPTION_ALLCLASSES);
			}
		});

		optionsPanel.add(htmlFeatures);

		HTML htmlSource = new HTML("<font size=1>Source</font>");

		htmlSource.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				showTree(OptionsIcons.OPTION_SOURCE);
			}
		});

		optionsPanel.add(htmlSource);

		return optionsPanel;
	}

	private static void showTree(int viewOption) {

		featuresTreePanel.clear();

		if (viewOption == OptionsIcons.OPTION_SOURCE) {

			featuresTreePanel.add(new ListFiles(
					ProjectInitialization.projectEntries));
		} else {

			featuresTreePanel.add(new ComponentsList());
		}
	}

	public static void showClass(ClassFile entry, int viewOption) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel
				.add(new FeatureVizualizationPanel(entry));

		if (viewOption == OptionsIcons.OPTION_DESCRIPTION) {

			FeatureVizualizationPanel.featureContent
					.add(new FeatureDescription(entry));

		} else if (viewOption == OptionsIcons.OPTION_SOURCE) {

			// new SourceCodeView(entry);
		}
	}

}
