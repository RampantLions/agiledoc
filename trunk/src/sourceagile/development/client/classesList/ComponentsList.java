package sourceagile.development.client.classesList;

import java.util.HashMap;
import java.util.List;

import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.ProjectComponents;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public class ComponentsList extends VerticalPanel {

	public ComponentsList(int viewOption) {

		List<ProjectComponents> projectComponents = ProjectInitialization.currentProject
				.getProjectComponents();

		this.setSpacing(20);

		TreePanel treePanel = new TreePanel();
		treePanel.setBorder(false);
		treePanel.setLines(false);

		TreeNode componentRoot = new TreeNode("");
		componentRoot.setId("componentRoot");

		treePanel.setRootNode(componentRoot);
		treePanel.setRootVisible(false);

		if (OptionsIcons.OPTION_REQUIREMENTS == viewOption) {

			treePanel.expandAll();
		}
		this.add(treePanel);

		String currentComponentPath = "componentRoot";

		for (ProjectComponents projectComponent : projectComponents) {

			HashMap<String, ClassFile> componentClasses = listComponentClasses(
					ProjectInitialization.projectEntries,
					projectComponent.getComponentPath(), viewOption);

			if (componentClasses != null && componentClasses.size() > 0) {

				String[] componentPath = projectComponent.getComponentName()
						.split("/");

				for (int i = 0; i < componentPath.length; i++) {

					TreeNode componentParentNode = treePanel
							.getNodeById(currentComponentPath);

					currentComponentPath += "/" + componentPath[i];

					if (treePanel.getNodeById(currentComponentPath) == null) {

						TreeNode emptyNode = new TreeNode("");
						emptyNode
								.setIcon("js/ext/resources/images/default/tree/empty.gif");
						componentParentNode.appendChild(emptyNode);

						TreeNode node = new TreeNode(
								FeatureNameGenerator.spacedName(
										componentPath[i],
										ProjectInitialization.currentProject
												.getProjectLocale()));
						node.setId(currentComponentPath);

						componentParentNode.appendChild(node);
					}
				}

				TreeNode componentParentNode = treePanel
						.getNodeById(currentComponentPath);

				new ComponentClassesList(treePanel, componentParentNode,
						componentClasses, projectComponent.getComponentPath(),
						viewOption);

				currentComponentPath = "componentRoot";

			}
		}
	}

	private HashMap<String, ClassFile> listComponentClasses(
			HashMap<String, ClassFile> entries, String specificationPath,
			int viewOption) {

		HashMap<String, ClassFile> componentClasses = new HashMap<String, ClassFile>();

		for (ClassFile entry : entries.values()) {

			if (specificationPath != null
					&& entry.getFilePath().startsWith(specificationPath)) {

				if (OptionsIcons.OPTION_REQUIREMENTS != viewOption
						|| (entry.getClassDoc() != null && (ClassDocumentation.FEATURE_TAG
								.equals(entry.getClassDoc().getTagType()) || ClassDocumentation.MAIN_FEATURE_TAG
								.equals(entry.getClassDoc().getTagType())))) {

					componentClasses.put(entry.toString(), entry);
				}
			}
		}

		return componentClasses;
	}

}
