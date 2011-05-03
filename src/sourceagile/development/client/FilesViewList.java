package sourceagile.development.client;

import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.classesList.ListDevelopmentFiles;
import sourceagile.development.client.classesList.ListFiles;
import sourceagile.development.client.features.ButtonFeatureDescription;
import sourceagile.development.client.features.ButtonSourceCode;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.development.client.sourceCode.SourceCodeView;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;

public class FilesViewList extends ListBox {

	public static final String VIEW_MAIN_FEATURES = "Main Features";
	public static final String VIEW_FEATURES = "Features";
	public static final String VIEW_USER_INTERFACE = "User Interface";
	public static final String VIEW_ARCHITECTURE = "Architecture";
	public static final String VIEW_ENTITIES = "Entities";
	public static final String VIEW_DEVELOPMENT_FILES = "Development Files";
	public static final String VIEW_SOURCE_CODE = "Source Code";

	public FilesViewList() {

		this.setWidth("200px");

		this.addItem(VIEW_MAIN_FEATURES);
		this.addItem(VIEW_FEATURES);
		this.addItem(VIEW_USER_INTERFACE);
		this.addItem(VIEW_ARCHITECTURE);
		this.addItem(VIEW_ENTITIES);
		this.addItem(VIEW_DEVELOPMENT_FILES);
		this.addItem(VIEW_SOURCE_CODE);

		this.setSelectedIndex(5);

		this.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				showClassesTree(getValue(getSelectedIndex()));
			}
		});
	}

	public static void showClassesTree(String viewOption) {

		Development.featuresTreePanel.clear();

		if (VIEW_DEVELOPMENT_FILES.equals(viewOption)) {

			Development.featuresTreePanel.add(new ListDevelopmentFiles(
					ProjectInitialization.projectEntries));

		} else if (VIEW_SOURCE_CODE.equals(viewOption)) {

			Development.featuresTreePanel.add(new ListFiles(
					ProjectInitialization.projectEntries));
		} else {

			Development.featuresTreePanel.add(new ListDevelopmentFiles(
					ProjectInitialization.projectEntries));
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
}
