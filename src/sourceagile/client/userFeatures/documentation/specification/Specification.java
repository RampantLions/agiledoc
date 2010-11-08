package sourceagile.client.userFeatures.documentation.specification;

import sourceagile.client.SystemStart;
import sourceagile.client.userFeatures.documentation.classViewOptions.ClassVizualizationPanel;
import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.documentation.features.FeatureDescription;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.codeview.client.ClassesList;
import sourceagile.codeview.client.SourceCodeView;
import sourceagile.shared.ClassFile;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show all the classes of the current project as a specification format.
 * 
 * @feature
 */
public class Specification {

	public VerticalPanel featuresTreePanel = new VerticalPanel();
	public static VerticalPanel featureVisualizationPanel = new VerticalPanel();

	public Specification() {

		this(null, OptionsIcons.OPTION_DESCRIPTION);
	}
	
	public Specification(int viewOption) {

		this(null, viewOption);
	}

	public Specification(ClassFile entry, int viewOption) {

		SystemStart.mainPage.panelContent.clear();

		VerticalPanel vp = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();

		featuresTreePanel.clear();
		featuresTreePanel.setSize("350px", "100%");

		hp.add(featuresTreePanel);

		if (viewOption == OptionsIcons.OPTION_SOURCE) {

			featuresTreePanel.add(new ClassesList(
					ProjectInitialization.projectEntries));

		} else if (viewOption == OptionsIcons.OPTION_ALLCLASSES) {
		
			featuresTreePanel.add(new AllClassesSpecificationList(
					ProjectInitialization.projectEntries));
		} else {

			featuresTreePanel.add(new SpecificationItemsList(
					ProjectInitialization.projectEntries));
		}

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		hp.add(featureVisualizationPanel);

		if (entry != null) {

			showClass(entry, viewOption);
		}

		vp.add(hp);

		SystemStart.mainPage.panelContent.add(vp);
	}

	public static void showClass(ClassFile entry, int viewOption) {

		Specification.featureVisualizationPanel.clear();
		Specification.featureVisualizationPanel
				.add(new ClassVizualizationPanel(entry));

		if (viewOption == OptionsIcons.OPTION_DESCRIPTION) {

			ClassVizualizationPanel.featureContent.add(new FeatureDescription(
					entry));

		} else if (viewOption == OptionsIcons.OPTION_SOURCE) {

			new SourceCodeView(entry);
		}
	}

}
