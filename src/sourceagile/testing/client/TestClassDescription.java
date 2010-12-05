package sourceagile.testing.client;

import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.codeview.client.SourceCodeView;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.testing.client.serverCalls.AddTestClass;

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

			FeatureVizualizationPanel.featureContent.add(new Label(" "));

			FeatureVizualizationPanel.featureContent
					.add(addSourceButton(testEntry));

		} else {

			FeatureVizualizationPanel.featureContent.clear();

			FeatureVizualizationPanel.featureContent
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

				Development.featureVisualizationPanel.clear();
				Development.featureVisualizationPanel.add(new LoadingPanel());

				new AddTestClass(entry);
			}
		});

		vp.add(button);

		return vp;
	}

	private Button addSourceButton(final ClassFile entry) {

		Button button = new Button("View Source");

		button.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				new SourceCodeView(entry);
			}
		});

		return button;
	}

}
