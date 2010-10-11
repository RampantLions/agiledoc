package sourceagile.client.userFeatures.testing;

import sourceagile.client.serverCalls.test.AddTestClass;
import sourceagile.client.userFeatures.features.FeatureDescription;
import sourceagile.client.userFeatures.specification.classViewOptions.ClassVizualizationPanel;
import sourceagile.shared.ClassFile;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * Show the specification of the Test Class.
 * 
 * @feature
 */
public class TestClassDescription extends VerticalPanel {

	public TestClassDescription(ClassFile classEntry, ClassFile testEntry) {

		if (testEntry != null) {

			new FeatureDescription(testEntry);

		} else {

			ClassVizualizationPanel.featureContent.clear();

			ClassVizualizationPanel.featureContent
					.add(getNoTestPanel(classEntry));

		}
	}

	private VerticalPanel getNoTestPanel(final ClassFile entry) {

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(30);

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Label label = new Label("No test created.");

		vp.add(label);

		Button button = new Button("Create a new Test");

		button.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				new AddTestClass(entry);
			}
		});

		vp.add(button);

		return vp;
	}

}
