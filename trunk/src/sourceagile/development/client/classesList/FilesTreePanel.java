package sourceagile.development.client.classesList;

import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public class FilesTreePanel extends TreePanel {

	public FilesTreePanel(TreeNode root) {

		this.setBorder(false);
		this.setLines(false);

		this.setRootNode(root);
		this.setRootVisible(false);
		this.expandAll();
	}
}
