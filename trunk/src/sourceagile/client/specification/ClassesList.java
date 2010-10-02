package sourceagile.client.specification;

import sourceagile.client.specification.classViewOptions.OptionsIcons;
import sourceagile.shared.ClassFile;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class ClassesList extends TreePanel {

	TreeNode root = new TreeNode();

	public ClassesList(ClassFile[] entries) {

		this.setBorder(false);
		this.setLines(false);
		this.setRootVisible(false);

		TreeNode[] treeItemArray = new TreeNode[10];

		String currentClassPath = null;

		for (int i = 0; i < entries.length; i++) {

			ClassFile entry = entries[i];

			if (!entry.getClassPath().equals(currentClassPath)) {

				String[] level = entry.getClassPath().split("/");

				if (!entry.getClassPath().equals("")) {

					if (treeItemArray[level.length - 1] == null) {

						treeItemArray[level.length - 1] = new TreeNode(entry
								.getFeature().getFeatureFolder());

					} else {

						int j = level.length - 1;
						while (treeItemArray[j] != null) {

							if (j == 0) {

								root.appendChild(treeItemArray[j]);

							} else {

								treeItemArray[j - 1]
										.appendChild(treeItemArray[j]);
							}
							j++;
						}

						j = level.length - 1;
						while (treeItemArray[j] != null) {

							treeItemArray[j] = null;
							j++;
						}

						treeItemArray[level.length - 1] = new TreeNode(entry
								.getFeature().getFeatureFolder());
					}
				}

				currentClassPath = entry.getClassPath();

				ListFilesFromFolder(entries, i,
						treeItemArray[level.length - 1], currentClassPath);
			}
		}

		int i = 1;
		while (treeItemArray[i] != null) {

			treeItemArray[i - 1].appendChild(treeItemArray[i]);

			i++;
		}

		if (treeItemArray[0] != null) {
			root.appendChild(treeItemArray[0]);
		}

		this.setRootNode(root);
		this.expandAll();

	}

	private void ListFilesFromFolder(ClassFile[] entries, int folderIndex,
			TreeNode currentTreeItem, String currentClassPath) {

		int i = folderIndex;
		ClassFile entry = entries[i];

		while (currentClassPath.equals(entry.getClassPath())
				&& i < entries.length) {

			final ClassFile entryFinal = entry;

			if (currentClassPath.equals("")) {

				TreeNode treeNode = getFeatureLink(entryFinal, entry
						.getFeature().getFeatureName());

				root.appendChild(treeNode);

			} else {

				TreeNode treeNode = getFeatureLink(entryFinal, entry
						.getFeature().getFeatureName());

				currentTreeItem.appendChild(treeNode);
			}

			i++;

			if (i < entries.length) {
				entry = entries[i];
			}
		}
	}

	private TreeNode getFeatureLink(final ClassFile entry, String nodeName) {

		TreeNode treeNode = new TreeNode(nodeName);

		treeNode.setIcon("js/ext/resources/images/default/tree/world.gif");

		// treeNode.setIconCls("world-icon");

		treeNode.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				Specification.showClass(entry, OptionsIcons.optionDescription);
			}
		});

		return treeNode;
	}

}
