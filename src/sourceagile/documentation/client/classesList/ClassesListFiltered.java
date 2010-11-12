package sourceagile.documentation.client.classesList;

import sourceagile.documentation.client.classViewOptions.OptionsIcons;
import sourceagile.documentation.client.specification.Specification;
import sourceagile.documentation.client.specification.SpecificationList;
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
public class ClassesListFiltered extends VerticalPanel {

	public ClassesListFiltered(ClassFile[] entries, String tagType) {

		this.add(SpecificationList.typeHeader(tagType));

		for (final ClassFile entry : entries) {

			if (entry.getClassDoc().getTagType() != null
					&& entry.getClassDoc().getTagType().equals(tagType)) {

				String name = "<br><B>" + entry.getFeature().getFeatureName()
						+ "</B> ";

				String description = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ entry.getClassDoc().getDescription();

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
	}

}
