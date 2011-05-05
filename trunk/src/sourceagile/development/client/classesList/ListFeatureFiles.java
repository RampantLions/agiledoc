package sourceagile.development.client.classesList;

import java.util.HashMap;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.FeatureNameGenerator;
import sourceagile.shared.utilities.SortClassFiles;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.tree.TreeNode;

public class ListFeatureFiles extends VerticalPanel {

	public ListFeatureFiles(HashMap<String, ClassFile> entries, String tagType) {

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

			if (entry.getClassDoc() != null) {

				if ((tagType.equals(ClassDocumentation.FEATURE_TAG) && (ClassDocumentation.FEATURE_TAG
						.equals(entry.getClassDoc().getTagType()) || ClassDocumentation.MAIN_FEATURE_TAG
						.equals(entry.getClassDoc().getTagType())))

						||

						(tagType.equals(ClassDocumentation.USER_INTERFACE_TAG) && (ClassDocumentation.FEATURE_TAG
								.equals(entry.getClassDoc().getTagType())
								|| ClassDocumentation.MAIN_FEATURE_TAG
										.equals(entry.getClassDoc()
												.getTagType()) || ClassDocumentation.USER_INTERFACE_TAG
								.equals(entry.getClassDoc().getTagType())))

				) {

					String[] entryPath = entry.getFilePath().split("/");

					for (int i = 0; i < entryPath.length; i++) {

						TreeNode parentNode = treePanel
								.getNodeById(currentPath);

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
}
