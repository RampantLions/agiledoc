package sourceagile.documentation.client.classesList;

import sourceagile.documentation.client.classViewOptions.OptionsIcons;
import sourceagile.documentation.client.specification.Specification;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class ComponentClassesList {

	public ComponentClassesList(TreePanel tree, TreeNode componentNode,
			ClassFile[] entries, String specificationPath) {

		String currentPath = componentNode.getId();

		int specPathSize = 0;
		if (specificationPath != null && specificationPath.length() > 0) {

			specPathSize = specificationPath.split("/").length;
		}

		for (ClassFile entry : entries) {

			if (specificationPath != null
					&& entry.getFilePath().startsWith(specificationPath)) {

				String[] entryPath = entry.getFilePath().split("/");

				for (int i = specPathSize; i < entryPath.length; i++) {

					TreeNode parentNode = tree.getNodeById(currentPath);

					if (!entryPath[i].equals("")) {

						currentPath += "/" + entryPath[i];

						if (tree.getNodeById(currentPath) == null) {

							TreeNode node = new TreeNode(
									FeatureNameGenerator
											.spacedName(entryPath[i]));
							node.setExpanded(true);
							node.setId(currentPath);
							node.setIcon("js/ext/resources/images/default/tree/empty.gif");

							parentNode.appendChild(node);
						}
					}
				}

				TreeNode parentNode = tree.getNodeById(currentPath);

				TreeNode node = getFeatureLink(entry);
				node.setId(entry.getFilePath() + "." + entry.getFileName());
				node.setExpanded(true);

				parentNode.appendChild(node);

				currentPath = componentNode.getId();
			}
		}
	}

	private TreeNode getFeatureLink(final ClassFile entry) {

		TreeNode treeNode = new TreeNode(entry.getFeature().getFeatureName());

		treeNode.setIcon("js/ext/resources/images/default/tree/world.gif");

		treeNode.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				Specification.showClass(entry, OptionsIcons.OPTION_DESCRIPTION);
			}
		});

		return treeNode;
	}

}
