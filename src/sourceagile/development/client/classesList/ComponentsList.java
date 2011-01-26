package sourceagile.development.client.classesList;

import java.util.List;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.project.ProjectComponents;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public class ComponentsList extends VerticalPanel {

	public ComponentsList() {

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
		// treePanel.expandAll();
		this.add(treePanel);

		String currentComponentPath = "componentRoot";

		for (ProjectComponents projectComponent : projectComponents) {

			String[] componentPath = projectComponent.getComponentName().split(
					"/");

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
							FeatureNameGenerator.spacedName(componentPath[i]));
					node.setId(currentComponentPath);

					componentParentNode.appendChild(node);
				}
			}

			TreeNode componentParentNode = treePanel
					.getNodeById(currentComponentPath);

			new ComponentClassesList(treePanel, componentParentNode,
					ProjectInitialization.projectEntries,
					projectComponent.getComponentPath());

			currentComponentPath = "componentRoot";
		}
	}

}
