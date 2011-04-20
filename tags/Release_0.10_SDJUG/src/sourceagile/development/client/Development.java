package sourceagile.development.client;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.classesList.ComponentsList;
import sourceagile.development.client.classesList.ListFiles;
import sourceagile.development.client.features.ButtonFeatureDescription;
import sourceagile.development.client.features.ButtonSourceCode;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.development.client.sourceCode.SourceCodeView;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show all the classes of the current project as a specification format.
 * 
 * @Feature
 */
public class Development {

	public static VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	public static LinkRequirements linkRequirements = new LinkRequirements();
	public static LinkFeatures linkFeatures = new LinkFeatures();
	public static LinkSource linkSource = new LinkSource();

	public Development() {

		this(null, OptionsIcons.OPTION_REQUIREMENTS);
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

		showClassesTree(viewOption);

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

		optionsPanel.add(linkRequirements);

		Label labelspace = new Label(" ");
		labelspace.setWidth("30px");
		optionsPanel.add(labelspace);

		optionsPanel.add(linkFeatures);

		Label labelspace2 = new Label(" ");
		labelspace2.setWidth("30px");
		optionsPanel.add(labelspace2);

		optionsPanel.add(linkSource);

		return optionsPanel;
	}

	public static void showClassesTree(int viewOption) {

		featuresTreePanel.clear();

		toggledLinks();

		if (viewOption == OptionsIcons.OPTION_REQUIREMENTS) {

			linkRequirements.setHTML(LinkRequirements.textPressed);

			featuresTreePanel.add(new ComponentsList(viewOption));

		} else if (viewOption == OptionsIcons.OPTION_SOURCE) {

			linkSource.setHTML(LinkSource.textPressed);

			featuresTreePanel.add(new ListFiles(
					ProjectInitialization.projectEntries));
		} else {

			linkFeatures.setHTML(LinkFeatures.textPressed);

			featuresTreePanel.add(new ComponentsList(viewOption));
		}
	}

	public static void showClass(ClassFile entry, int viewOption) {

		Development.featureVisualizationPanel.clear();
		Development.featureVisualizationPanel
				.add(new FeatureVizualizationPanel(entry));

		FeatureVizualizationPanel.featureContent.clear();

		if (viewOption == OptionsIcons.OPTION_DESCRIPTION) {

			OptionsIcons.buttonDescription
					.setHTML(ButtonFeatureDescription.imagePressed);

			FeatureVizualizationPanel.featureContent
					.add(new FeatureDescription(entry));

		} else if (viewOption == OptionsIcons.OPTION_SOURCE) {

			OptionsIcons.buttonSourceCode
					.setHTML(ButtonSourceCode.imagePressed);

			new SourceCodeView(entry);
		}
	}

	public static void toggledLinks() {

		linkRequirements.setHTML(LinkRequirements.textUnpressed);
		linkFeatures.setHTML(LinkFeatures.textUnpressed);
		linkSource.setHTML(LinkSource.textUnpressed);
	}
}
