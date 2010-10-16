package sourceagile.client.userFeatures.features;

import sourceagile.client.userFeatures.specification.Specification;
import sourceagile.client.userFeatures.specification.classViewOptions.OptionsIcons;
import sourceagile.shared.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
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

			if (entry.getClassDoc().isFeature()) {

				String name = "<br><B>" + entry.getFeature().getFeatureName()
						+ "</B> ";

				String description = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <FONT SIZE=1>"
						+ entry.getClassDoc().getDescription() + "</FONT>";

				HTML html = new HTML(name + description);

				html.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new Specification(entry,
								OptionsIcons.OPTION_DESCRIPTION);
					}
				});

				this.add(html);
			}
		}

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new Label(" "));

		this.add(exportXMLButton(entries));
	}

	private Button exportXMLButton(final ClassFile[] entries) {

		Button button = new Button("Export XML",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new FeaturesListXML(entries);
			}
		});

		return button;
	}

}
