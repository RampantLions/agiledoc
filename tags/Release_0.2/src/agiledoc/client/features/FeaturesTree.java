package agiledoc.client.features;

import agiledoc.client.features.featureOptions.OptionsIcons;
import agiledoc.client.serverConnection.GetRemoteClass;
import agiledoc.shared.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class FeaturesTree extends Tree {

	public FeaturesTree(Entry[] entries) {

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

								this.addItem(treeItemArray[j]);

							} else {

								treeItemArray[j - 1].addItem(treeItemArray[j]);
							}
							j++;
						}

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

					treeItemArray[level.length - 1].addItem("<br>");

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
		this.addItem(treeItemArray[0]);
	}

	private void ListFilesFromFolder(Entry[] entries, int folderIndex,
			TreeItem currentTreeItem, String currentClassPath) {

		int i = folderIndex;
		Entry entry = entries[i];

		while (currentClassPath.equals(entry.getClassPath())
				&& i < entries.length - 1) {

			if (currentClassPath.equals("")) {

				this.addItem(getFeatureAnchor(entry, entry.getFeature()
						.getFeatureName()));

			} else {

				currentTreeItem.addItem(getFeatureAnchor(entry, entry
						.getFeature().getFeatureName()));
			}

			i++;
			entry = entries[i];
		}
	}

	private Anchor getFeatureAnchor(final Entry entry, String anchorName) {

		Anchor featureAnchor = new Anchor(anchorName);
		featureAnchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				new GetRemoteClass(entry, OptionsIcons.optionDescription);
			}
		});

		return featureAnchor;
	}

}