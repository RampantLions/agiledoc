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

		ListFiles(entries);

		ListSubFolders(entries);

	}

	private void ListFiles(List<Entry> entries) {

		for (Entry entry : entries) {

			if (entry.isFile()) {

				Anchor featureAnchor = new Anchor(entry.getEntryName());
				featureAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

					}
				});

				this.addItem(featureAnchor);
			}
		}
	}

	private void ListSubFolders(List<Entry> entries) {

		for (Entry entry : entries) {

			if (!entry.isFile()) {

				TreeItem packItem = new TreeItem(entry.getEntryName());

				this.addItem(packItem);
			}
		}
	}

}
