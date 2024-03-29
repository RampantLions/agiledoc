package sourceagile.development.client.classesList;

import java.util.HashMap;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.FeatureNameGenerator;
import sourceagile.shared.utilities.SortClassFiles;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.tree.TreeNode;

public class ListDevelopmentFiles extends VerticalPanel {

	public ListDevelopmentFiles(HashMap<String, ClassFile> entries) {

		this.setSpacing(10);

		Label labelSpace = new Label(" ");
		this.add(labelSpace);

		TreeNode root = new TreeNode("");
		root.setId("root");

		FilesTreePanel treePanel = new FilesTreePanel(root);

		this.add(treePanel);

		String currentPath = "root";

		ClassFile[] classFiles = SortClassFiles.getSortedArray(entries);

		for (ClassFile entry : classFiles) {

			if (ClassFile.EXTENSION_FEATURE.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_JAVA
							.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_JSP.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_JS.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_CSS.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_HTML
							.equals(entry.getFileExtension())
					|| ClassFile.EXTENSION_XML.equals(entry.getFileExtension())) {

				String[] entryPath = entry.getFilePath().split("/");

				for (int i = 0; i < entryPath.length; i++) {

					TreeNode parentNode = treePanel.getNodeById(currentPath);

					if (!entryPath[i].equals("")) {

						currentPath += "/" + entryPath[i];

						if (treePanel.getNodeById(currentPath) == null) {

							TreeNode node = new TreeNode(
									FeatureNameGenerator
											.spacedName(
													entryPath[i],
													ProjectInitialization.currentProject
															.getProjectLocale()));
							node.setId(currentPath);

							parentNode.appendChild(node);

						}
					}
				}

				TreeNode parentNode = treePanel.getNodeById(currentPath);

				FeatureNameLink node = new FeatureNameLink(entry);
				node.setId(entry.getFilePath() + "." + entry.getFileName());

				parentNode.appendChild(node);

				currentPath = "root";
			}
		}
	}
}
