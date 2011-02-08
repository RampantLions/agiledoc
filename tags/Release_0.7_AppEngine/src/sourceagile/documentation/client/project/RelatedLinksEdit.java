package sourceagile.documentation.client.project;

import sourceagile.client.ProjectInitialization;
import sourceagile.documentation.client.serverCalls.UpdateRelatedLinks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class RelatedLinksEdit extends VerticalPanel {

	private static RichTextArea relatedLinks = new RichTextArea();

	public RelatedLinksEdit() {

		this.setSpacing(30);

		VerticalPanel vp = new VerticalPanel();

		relatedLinks.setSize("100%", "500px");

		relatedLinks.setHTML(ProjectInitialization.currentProject
				.getRelatedLinks());

		RichTextToolbar toolbar = new RichTextToolbar(relatedLinks);
		toolbar.setWidth("100%");

		vp.add(toolbar);
		vp.add(relatedLinks);

		this.add(vp);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(buttonSave());

	}

	private Button buttonSave() {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ProjectInitialization.currentProject
						.setRelatedLinks(relatedLinks.getHTML());

				new UpdateRelatedLinks(ProjectInitialization.currentProject);
			}
		});

		return button;
	}

}
