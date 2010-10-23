package sourceagile.client.userFeatures.documentation;

import sourceagile.client.userFeatures.documentation.classViewOptions.OptionsIcons;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Method;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UserManual extends VerticalPanel {

	public UserManual(ClassFile[] entries) {

		this.setSpacing(20);

		String specificationPath = ProjectInitialization.currentProject
				.getSpecificationPath();

		for (final ClassFile entry : entries) {

			if (specificationPath != null
					&& entry.getFilePath().startsWith(specificationPath)
					&& !entry.getClassDoc().isTodo()) {

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

				this.add(featureMethods(entry.getClassDoc()
						.getMethods()));
			}
		}
	}
	
	public static Grid featureMethods(final Method[] meths) {

		Grid table = new Grid(meths.length * 3, 2);

		table.getColumnFormatter().setWidth(0, "40");

		for (int i = 0; i < meths.length; i++) {

			Method meth = meths[i];

			if (meth.getDescription() != null
					&& !meth.getDescription().equals("")) {

				table.setWidget((i * 3 + 1), 1, new HTML(meth.getDescription()));
			}

			table.setWidget((i * 3 + 2), 0, new Label(" "));
		}

		return table;
	}
}
