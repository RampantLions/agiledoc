package sourceagile.client.userFeatures.documentation.features;

import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * List all the features assigned for the current project.
 * 
 * @feature
 */
public class FeaturesList extends VerticalPanel {

	public FeaturesList(ClassFile[] entries) {

		this.setSpacing(20);

		for (final ClassFile entry : entries) {

			if (entry.getClassDoc().getTagType() != null
					&& entry.getClassDoc().getTagType()
							.equals(ClassDocumentation.FEATURE_TAG)) {

				String name = "<br><B>" + entry.getFeature().getFeatureName()
						+ "</B> ";

				String description = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ entry.getClassDoc().getDescription();

				String planning = "";
				if (entry.getClassDoc().isTodo()) {

					planning = " <font color='blue'>(Planning)</blue> ";
				}

				HTML html = new HTML(name + description + planning);

				html.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new Specification(entry,
								OptionsIcons.OPTION_DESCRIPTION);
					}
				});

				this.add(html);
			}
		}
	}

}
