package sourceagile.client.features;

import sourceagile.shared.Entry;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturesList extends VerticalPanel {

	public FeaturesList(Entry[] entries) {

		for (Entry entry : entries) {

			String name = "<B>" + entry.getFeature().getFeatureName() + "</B> "
					+ entry.getFeature().getFeatureFolder();

			add(new HTML(name));

		//	String description = "<FONT SIZE=1>"
		//			+ entry.getClassDoc().getDescription() + "</FONT>";
			
		//	add(new HTML(description));
		}

	}

}
