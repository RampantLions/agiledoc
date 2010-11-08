package sourceagile.testing.client;

import sourceagile.client.systemNavigation.LoadingPanel;
import sourceagile.client.userFeatures.documentation.classViewOptions.ClassVizualizationPanel;
import sourceagile.client.userFeatures.documentation.features.FeatureDescription;
import sourceagile.client.userFeatures.documentation.specification.Specification;
import sourceagile.codeview.client.SourceCodeView;
import sourceagile.shared.ClassFile;
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

			ClassVizualizationPanel.featureContent.add(new Label(" "));

			ClassVizualizationPanel.featureContent
					.add(addSourceButton(testEntry));

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

				Specification.featureVisualizationPanel.clear();
				Specification.featureVisualizationPanel.add(new LoadingPanel());

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
