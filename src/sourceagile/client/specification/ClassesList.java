package sourceagile.client.specification;

import sourceagile.client.serverConnection.GetRemoteClass;
import sourceagile.client.specification.classViewOptions.OptionsIcons;
import sourceagile.shared.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class ClassesList extends Tree {

	public ClassesList(ClassFile[] entries) {

		TreeItem[] treeItemArray = new TreeItem[10];

		String currentClassPath = null;

		for (int i = 0; i < entries.length; i++) {

			ClassFile entry = entries[i];

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

								this.addItem(treeItemArray[j]);

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
						treeItemArray[level.length - 1], currentClassPath);

				if (currentClassPath.equals("")) {

					this.addItem("<br>");

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
			this.addItem(treeItemArray[0]);
		}

	}

	private void ListFilesFromFolder(ClassFile[] entries, int folderIndex,
			TreeItem currentTreeItem, String currentClassPath) {

		int i = folderIndex;
		ClassFile entry = entries[i];

		while (currentClassPath.equals(entry.getClassPath())
				&& i < entries.length) {

			if (currentClassPath.equals("")) {

				this.addItem(getFeatureAnchor(entry, entry.getFeature()
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

	private Anchor getFeatureAnchor(final ClassFile entry, String anchorName) {

		Anchor featureAnchor = new Anchor(anchorName);
		featureAnchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				new GetRemoteClass(entry, OptionsIcons.optionDescription);
			}
		});

		return featureAnchor;
	}

}
