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

		ListFilesFromFolder(entries, null, "");

		TreeItem currentTreeNode = null;

		String currentFolder = "none";

		for (Entry entry : entries) {

			if (!entry.getClassPath().equals("")
					&& !entry.getClassPath().equals(currentFolder)) {

				if (!entry.getClassPath().contains(currentFolder)) {

					currentFolder = entry.getClassPath();

					currentTreeNode = new TreeItem("<br>"
							+ entry.getFeature().getFeatureFolder());

					ListFilesFromFolder(entries, currentTreeNode, currentFolder);

					currentTreeNode.setState(true);

					this.addItem(currentTreeNode);

				} else {

					String featureName = entry.getFeature().getFeatureFolder()
							+ " / " + entry.getFeature().getFeatureName();

					currentTreeNode
							.addItem(getFeatureAnchor(entry, featureName));
				}
			}
		}
	}

	private void ListFilesFromFolder(Entry[] entries, TreeItem currentTreeNode,
			String currentFolder) {

		for (Entry entry : entries) {

			if (currentFolder.equals(entry.getClassPath())) {

				if (currentFolder.equals("")) {

					this.addItem(getFeatureAnchor(entry, entry.getFeature()
							.getFeatureName()));

				} else {

					currentTreeNode.addItem(getFeatureAnchor(entry, entry
							.getFeature().getFeatureName()));
				}
			}
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
