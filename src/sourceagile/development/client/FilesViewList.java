package sourceagile.development.client;

import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.classesList.ListDevelopmentFiles;
import sourceagile.development.client.classesList.ListFeatureFiles;
import sourceagile.development.client.classesList.ListFiles;
import sourceagile.development.client.classesList.ListFilesFiltered;
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

	public static final String VIEW_MAIN_FEATURES = "MainFeature";
	public static final String VIEW_FEATURES = "Feature";
	public static final String VIEW_USER_INTERFACE = "UserInterface";
	public static final String VIEW_ARCHITECTURE = "Architecture";
	public static final String VIEW_ENTITIES = "Entity";
	public static final String VIEW_DEVELOPMENT_FILES = "DevelopmentFiles";
	public static final String VIEW_SOURCE_CODE = "SourceCode";

	public FilesViewList() {

		this.setWidth("200px");

		this.addItem("Main Features", VIEW_MAIN_FEATURES);
		this.addItem("Features", VIEW_FEATURES);
		this.addItem("User Interface", VIEW_USER_INTERFACE);
		this.addItem("Architecture", VIEW_ARCHITECTURE);
		this.addItem("Entities", VIEW_ENTITIES);
		this.addItem("Development Files", VIEW_DEVELOPMENT_FILES);
		this.addItem("Source Code", VIEW_SOURCE_CODE);

		this.setSelectedIndex(1);

		this.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				showClassesTree(getValue(getSelectedIndex()));
			}
		});
	}

	public static void showClassesTree(String viewOption) {

		Development.featuresTreePanel.clear();

		if (VIEW_MAIN_FEATURES.equals(viewOption)
				|| VIEW_ARCHITECTURE.equals(viewOption)
				|| VIEW_ENTITIES.equals(viewOption)) {

			Development.featuresTreePanel.add(new ListFilesFiltered(
					ProjectInitialization.projectEntries, viewOption));

		} else if (VIEW_FEATURES.equals(viewOption)
				|| VIEW_USER_INTERFACE.equals(viewOption)) {

			Development.featuresTreePanel.add(new ListFeatureFiles(
					ProjectInitialization.projectEntries, viewOption));

		} else if (VIEW_DEVELOPMENT_FILES.equals(viewOption)) {

			Development.featuresTreePanel.add(new ListDevelopmentFiles(
					ProjectInitialization.projectEntries));

		} else if (VIEW_SOURCE_CODE.equals(viewOption)) {

			Development.featuresTreePanel.add(new ListFiles(
					ProjectInitialization.projectEntries));
		} else {

			Development.featuresTreePanel.add(new ListFeatureFiles(
					ProjectInitialization.projectEntries, VIEW_FEATURES));
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
