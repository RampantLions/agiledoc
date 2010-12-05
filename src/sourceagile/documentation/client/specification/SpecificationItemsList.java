package sourceagile.documentation.client.specification;

import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.FeatureNameGenerator;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class SpecificationItemsList extends VerticalPanel {

	public SpecificationItemsList(ClassFile[] entries) {

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

		String specificationPath = ProjectInitialization.currentProject
				.getSpecificationPath();

		int specPathSize = 0;
		if (specificationPath != null && specificationPath.length() > 0) {

			specPathSize = specificationPath.split("/").length;
		}

		for (ClassFile entry : entries) {

			if (specificationPath != null
					&& entry.getFilePath().startsWith(specificationPath)) {

				String[] entryPath = entry.getFilePath().split("/");

				for (int i = specPathSize; i < entryPath.length; i++) {

					TreeNode parentNode = treePanel.getNodeById(currentPath);

					if (!entryPath[i].equals("")) {

						currentPath += "/" + entryPath[i];

						if (treePanel.getNodeById(currentPath) == null) {

							if (i == specPathSize) {

								treePanel = new TreePanel();
								treePanel.setBorder(false);
								treePanel.setLines(false);

								root = new TreeNode(
										FeatureNameGenerator
												.spacedName(entryPath[i]));
								root.setId(currentPath);
								root.setIcon("js/ext/resources/images/default/tree/empty.gif");

								treePanel.setRootNode(root);
								treePanel.expandAll();
								this.add(treePanel);

							} else {

								TreeNode node = new TreeNode(
										FeatureNameGenerator
												.spacedName(entryPath[i]));
								node.setId(currentPath);
								node.setIcon("js/ext/resources/images/default/tree/empty.gif");

								parentNode.appendChild(node);
							}
						}
					}
				}

				TreeNode parentNode = treePanel.getNodeById(currentPath);

				TreeNode node = getFeatureLink(entry);
				node.setId(entry.getFilePath() + "." + entry.getFileName());

				parentNode.appendChild(node);

				currentPath = "root";

			}
		}

	}

	private TreeNode getFeatureLink(final ClassFile entry) {

		TreeNode treeNode = new TreeNode(entry.getFeature().getFeatureName());

		treeNode.setIcon("js/ext/resources/images/default/tree/world.gif");

		// treeNode.setIconCls("world-icon");

		treeNode.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				Development.showClass(entry, OptionsIcons.OPTION_DESCRIPTION);
			}
		});

		return treeNode;
	}

}
