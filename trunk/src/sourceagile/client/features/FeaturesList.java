package sourceagile.client.features;

import sourceagile.shared.Entry;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturesList extends HorizontalPanel {

	public FeaturesList(Entry[] entries) {

		this.setSpacing(20);

		this.add(new Label(" "));
		
		VerticalPanel vp = new VerticalPanel();

		vp.add(listTree(entries));

		this.add(vp);
	}

	public Tree listTree(Entry[] entries) {

		Tree tree = new Tree();

		TreeItem[] treeItemArray = new TreeItem[10];

		String currentClassPath = null;

		for (int i = 0; i < entries.length; i++) {

			Entry entry = entries[i];

			if (!entry.getClassPath().equals(currentClassPath)) {

				String[] level = entry.getClassPath().split("/");

				if (!entry.getClassPath().equals("")) {

					if (treeItemArray[level.length - 1] == null) {

						treeItemArray[level.length - 1] = new TreeItem(entry
								.getFeature().getFeatureFolder());

					} else {

						int j = level.length - 1;
						while (treeItemArray[j] != null) {

							if (j == 0) {

								tree.addItem(treeItemArray[j]);

							} else {

								treeItemArray[j - 1].addItem(treeItemArray[j]);
							}
							j++;
						}

						treeItemArray[j - 1].addItem("<br>");

						j = level.length - 1;
						while (treeItemArray[j] != null) {

							treeItemArray[j] = null;
							j++;
						}

						treeItemArray[level.length - 1] = new TreeItem(entry
								.getFeature().getFeatureFolder());
					}
				}

				currentClassPath = entry.getClassPath();

				ListFilesFromFolder(entries, i,
						treeItemArray[level.length - 1], currentClassPath, tree);

				if (currentClassPath.equals("")) {

					tree.addItem("<br>");

				} else {

					treeItemArray[level.length - 1].setState(true);
				}

			}
		}

		int i = 1;
		while (treeItemArray[i] != null) {

			treeItemArray[i - 1].addItem(treeItemArray[i]);
			treeItemArray[i - 1].setState(true);

			i++;
		}

		if (treeItemArray[0] != null) {
			tree.addItem(treeItemArray[0]);
		}

		return tree;

	}

	private void ListFilesFromFolder(Entry[] entries, int folderIndex,
			TreeItem currentTreeItem, String currentClassPath, Tree tree) {

		int i = folderIndex;
		Entry entry = entries[i];

		while (currentClassPath.equals(entry.getClassPath())
				&& i < entries.length) {

			if (currentClassPath.equals("")) {

				tree.addItem(getFeatureAnchor(entry, entry.getFeature()
						.getFeatureName()));

			} else {

				currentTreeItem.addItem(getFeatureAnchor(entry, entry
						.getFeature().getFeatureName()));
			}

			i++;

			if (i < entries.length) {
				entry = entries[i];
			}
		}
	}

	private HTML getFeatureAnchor(final Entry entry, String anchorName) {

		String name = "<br><B>" + entry.getFeature().getFeatureName() + "</B> ";
		// + entry.getFeature().getFeatureFolder();

		String description = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <FONT SIZE=1>"
				+ entry.getClassDoc().getDescription() + "</FONT>";

		return new HTML(name + description);
	}

}
