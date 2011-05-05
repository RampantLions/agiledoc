package sourceagile.development.client;

import sourceagile.client.GlobalVariables;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;

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

		vpTree.add(new FilesViewList());

		featuresTreePanel.setSize("350px", "100%");

		vpTree.add(featuresTreePanel);

		hp.add(vpTree);

		FilesViewList.showClassesTree(FilesViewList.VIEW_FEATURES);

		featureVisualizationPanel.clear();
		featureVisualizationPanel.setSpacing(20);
		hp.add(featureVisualizationPanel);

		if (entry != null) {

			FilesViewList.showClass(entry, viewOption);
		}

		vp.add(hp);

		GlobalVariables.mainPage.panelContent.add(vp);
	}

}
