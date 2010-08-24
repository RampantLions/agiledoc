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

		TreeItem rootTree = new TreeItem("Agile Documentation");

		rootTree.setState(true);

		String currentFolder = "";

		TreeItem superiorItem = rootTree;

		TreeItem currentItem = new TreeItem(entries.get(0).getFeature()
				.getFeatureFolder());

		for (Entry entry : entries) {

			if (currentFolder.equals(entry.getClassPath())) {

				ListFile(entry, currentItem);

			} else {

				currentFolder = entry.getClassPath();

				superiorItem.addItem(currentItem);

				currentItem = new TreeItem(entry.getFeature()
						.getFeatureFolder());
			}
		}

		this.addItem(rootTree);
	}

	private void ListFile(Entry entry, TreeItem treeItem) {

		treeItem.addItem(getFeatureAnchor(entry));
	}

	private Anchor getFeatureAnchor(Entry entry) {

		Anchor featureAnchor = new Anchor(entry.getFeature().getFeatureName());
		featureAnchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

			}
		});

		return featureAnchor;
	}

}
