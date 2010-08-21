package agiledoc.client.features;

import java.util.List;

import agiledoc.shared.Feature;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;

public class FeaturesTree extends Tree {

	public FeaturesTree(List<Feature> features) {

		for (Feature feature : features) {

			Anchor featureAnchor = new Anchor(feature.getName());
			featureAnchor.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent sender) {

				}
			});

			addItem(featureAnchor);

		}

	}

}
