package sourceagile.client.userFeatures.documentation;

import sourceagile.client.help.HelpMethod;
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

				String methods = entryMethods(entry.getClassDoc().getMethods());
				
				HTML html = new HTML(name + description + methods);

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

	private static String entryMethods(final Method[] methods) {

		String methodsText = "";

		for (int i = 0; i < methods.length; i++) {

			Method method = methods[i];

			if (method.getDescription() != null
					&& !method.getDescription().equals("")) {

				methodsText += "<blockquote>" + method.getDescription()
						+ "</blockquote>";
			}
		}

		return methodsText;
	}
}
