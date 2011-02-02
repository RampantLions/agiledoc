package sourceagile.development.client.classesList;

import java.util.HashMap;

import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.SortClassFiles;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Node;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

public class ListFiles extends VerticalPanel {

	public ListFiles(HashMap<String, ClassFile> entries) {

		Label space = new Label(" ");
		this.add(space);

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

		ClassFile[] classFiles = SortClassFiles.getSortedArray(entries);

		for (ClassFile entry : classFiles) {

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

				Development.showClass(entry, OptionsIcons.OPTION_SOURCE);
			}
		});

		return treeNode;
	}
}
