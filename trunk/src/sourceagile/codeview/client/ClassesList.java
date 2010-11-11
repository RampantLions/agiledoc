package sourceagile.codeview.client;

import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class ClassesList extends VerticalPanel {

	public ClassesList(ClassFile[] entries) {

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

		for (ClassFile entry : entries) {

			String[] entryPath = entry.getFilePath().split("/");

			for (int i = 0; i < entryPath.length; i++) {

				TreeNode parentNode = treePanel.getNodeById(currentPath);

				if (!entryPath[i].equals("")) {

					currentPath += "/" + entryPath[i];

					if (treePanel.getNodeById(currentPath) == null) {

						TreeNode node = new TreeNode(entryPath[i]);
						node.setId(currentPath);

						parentNode.appendChild(node);

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

	private TreeNode getFeatureLink(final ClassFile entry) {

		TreeNode treeNode = new TreeNode(entry.getFileName());

		treeNode.setIcon("js/ext/resources/images/default/tree/java.gif");

		treeNode.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				Specification.showClass(entry, OptionsIcons.OPTION_SOURCE);
			}
		});

		return treeNode;
	}

}
