package agiledoc.client.features;

import java.util.List;

import agiledoc.shared.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class FeaturesTree extends Tree {

	public FeaturesTree(List<Entry> entries) {

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

					currentTreeNode.addItem(getFeatureAnchor(entry.getFeature()
							.getFeatureFolder()
							+ " / "
							+ entry.getFeature().getFeatureName()));
				}
			}
		}
	}

	private void ListFilesFromFolder(List<Entry> entries,
			TreeItem currentTreeNode, String currentFolder) {

		for (Entry entry : entries) {

			if (currentFolder.equals(entry.getClassPath())) {

				if (currentFolder.equals("")) {

					this.addItem(getFeatureAnchor(entry.getFeature()
							.getFeatureName()));

				} else {

					currentTreeNode.addItem(getFeatureAnchor(entry.getFeature()
							.getFeatureName()));
				}
			}
		}
	}

	private Anchor getFeatureAnchor(String anchorName) {

		Anchor featureAnchor = new Anchor(anchorName);
		featureAnchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

			}
		});

		return featureAnchor;
	}

}
