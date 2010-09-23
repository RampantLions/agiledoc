package sourceagile.client.systemNavigation.systemMenu;

import sourceagile.client.SystemStart;
import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.specification.ClassesList;
import sourceagile.client.specification.SpecificationPage;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonSpecification extends Button {

	public ButtonSpecification() {

		this.setText("Specification");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				SystemStart.mainPage.panelContent.clear();

				SpecificationPage specPage = new SpecificationPage();

				specPage.featuresTreePanel.add(new ClassesList(
						ProjectInitialization.projectEntries));

				SystemStart.mainPage.panelContent.add(specPage);
			}
		});
	}

}
