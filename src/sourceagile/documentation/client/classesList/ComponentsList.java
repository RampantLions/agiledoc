package sourceagile.documentation.client.classesList;

import sourceagile.documentation.client.specification.Specification;
import sourceagile.shared.entities.project.ProjectComponents;
import sourceagile.shared.utilities.FeatureNameGenerator;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class ComponentsList extends VerticalPanel {

	public ComponentsList() {

		ProjectComponents[] projectComponents = ProjectInitialization.currentProject
				.getProjectComponents();

		if (projectComponents == null) {

			Specification.featuresTreePanel.add(new AllClassesList(
					ProjectInitialization.projectEntries));

		} else {

			this.setSpacing(20);

			TreePanel treePanel = new TreePanel();
			treePanel.setBorder(false);
			treePanel.setLines(false);

			TreeNode root = new TreeNode("");
			root.setId("root");

			treePanel.setRootNode(root);
			treePanel.setRootVisible(false);
			treePanel.expandAll();
			this.add(treePanel);

			String currentPath = "root";

			for (ProjectComponents projectComponent : projectComponents) {

				String[] componentPath = projectComponent.getComponentPath()
						.split("/");

				for (int i = 0; i < componentPath.length; i++) {

					TreeNode parentNode = treePanel.getNodeById(currentPath);

					if (!componentPath[i].equals("")) {

						currentPath += "/" + componentPath[i];

						if (treePanel.getNodeById(currentPath) == null) {

							if (i == 0) {

								treePanel = new TreePanel();
								treePanel.setBorder(false);
								treePanel.setLines(false);

								root = new TreeNode(
										FeatureNameGenerator
												.spacedName(componentPath[i]));
								root.setId(currentPath);
								root.setIcon("js/ext/resources/images/default/tree/empty.gif");

								treePanel.setRootNode(root);
								treePanel.expandAll();
								this.add(treePanel);

							} else {

								TreeNode node = new TreeNode(
										FeatureNameGenerator
												.spacedName(componentPath[i]));
								node.setId(currentPath);
								node.setIcon("js/ext/resources/images/default/tree/empty.gif");

								parentNode.appendChild(node);
							}
						}
					}
				}

				TreeNode parentNode = treePanel.getNodeById(currentPath);

				TreeNode node = getFeatureLink(projectComponent);
				node.setId(projectComponent.getComponentPath() + "."
						+ projectComponent.getComponentPath());

				parentNode.appendChild(node);

				currentPath = "root";
			}
		}
	}

	private TreeNode getFeatureLink(final ProjectComponents projectComponent) {

		TreeNode treeNode = new TreeNode(projectComponent.getComponentName());

		treeNode.setIcon("js/ext/resources/images/default/tree/world.gif");

		// treeNode.setIconCls("world-icon");

		treeNode.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				// Specification.showClass(entry,
				// OptionsIcons.OPTION_DESCRIPTION);
			}
		});

		return treeNode;
	}

}
